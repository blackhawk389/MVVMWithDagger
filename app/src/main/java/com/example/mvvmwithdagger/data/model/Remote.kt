package com.example.mvvmwithdagger.data.model

import androidx.room.*
import com.example.mvvmwithdagger.util.MainTypeConverter


@Entity(tableName = "city_weather")
@TypeConverters(MainTypeConverter::class)
class Remote(
    @ColumnInfo(name = "coordinates")
    var coord: Coord? = null,

    @ColumnInfo(name = "weather_list")
    var weather: List<Weather>? = null,

    @ColumnInfo(name = "base")
    var base: String? = null,

    @ColumnInfo(name = "main")
    var main: Main?= null,

    @ColumnInfo(name = "visibility")
    var visibility: Int = 0,

    @ColumnInfo(name = "wind")
    var wind: Wind? = null,

    @ColumnInfo(name = "clouds")
    var clouds: Clouds? = null,

    @ColumnInfo(name = "dt")
    var dt: Int = 0,

    @Ignore
    var sys: Sys? = null,

    @ColumnInfo(name = "id")
    @PrimaryKey()
    var id: Int = 0,

    @ColumnInfo(name = "name")
    var name: String? = null,

    @Ignore
    var cod: Int = 0
)