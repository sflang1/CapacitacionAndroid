package sitis.org.sitismvvmexample.data.db

import android.arch.persistence.room.*
import android.content.Context
import sitis.org.sitismvvmexample.data.models.Seguro
import java.util.*

class DateConverter {
    @TypeConverter
    fun dateToLong(date: Date) : Long = date.time

    @TypeConverter
    fun longToDate(long: Long): Date = Date(long)
}


@TypeConverters(DateConverter::class)
@Database(version = 1, entities = [Seguro::class])
abstract  class AppDatabaseConnection : RoomDatabase(){

    abstract  fun seguroDao():SeguroDao

    companion object {
        lateinit var db:AppDatabaseConnection

        fun init(context: Context){
            db = Room.databaseBuilder(context, AppDatabaseConnection::class.java, "seguros.db").build()
        }
    }
}