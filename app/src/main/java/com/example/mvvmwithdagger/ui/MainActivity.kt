package com.example.mvvmwithdagger.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmwithdagger.R
import com.example.mvvmwithdagger.data.RepositoryImpl
import com.example.mvvmwithdagger.data.local.LocalDataSourceImpl
import com.example.mvvmwithdagger.data.remote.RemoteDataSourceImpl
import com.example.mvvmwithdagger.databinding.ActivityMainBinding
import com.example.mvvmwithdagger.ui.weather_info.WeatherInfoViewModel
import com.example.mvvmwithdagger.ui.weather_info.WeatherInforViewModelFactory
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var binding : ActivityMainBinding
    lateinit var viewmodel : WeatherInfoViewModel;

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        if (p0.getItemId() == android.R.id.home) {
            binding.activityMain.openDrawer(Gravity.LEFT);
            return true
        }
        return super.onOptionsItemSelected(p0);
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.toolbar_menu_items, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return true
//        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewmodel = ViewModelProvider(this, WeatherInforViewModelFactory(RepositoryImpl(
            LocalDataSourceImpl(),RemoteDataSourceImpl())))
            .get(WeatherInfoViewModel::class.java)
        viewmodel.getMutableData()?.observe(this, Observer {
            binding.model = it
        });
//        setupNavigation()
        setupToolbar()
    }

    private fun setupToolbar() {
        binding.toolbar.setTitle("Weather Forcast")
        binding.toolbar.inflateMenu(R.menu.toolbar_menu_items)

        binding.toolbar.setOnMenuItemClickListener(Toolbar.OnMenuItemClickListener {
            viewmodel.getWeatherReport()
            true
        })
    }


    fun setupNavigation(){
        val actionBarDrawerToggle = object : ActionBarDrawerToggle(this, binding.activityMain, binding.toolbar, R.string.app_name, R.string.app_name) {
                override fun onDrawerOpened(drawerView: View) {
                    super.onDrawerOpened(drawerView)
                }

                override fun onDrawerClosed(drawerView: View) {
                    super.onDrawerClosed(drawerView)
                }
            }

        binding.activityMain.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
    }


}
