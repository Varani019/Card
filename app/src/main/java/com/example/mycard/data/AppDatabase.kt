package com.example.mycard.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [Businesscard::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun businessDao() : BusinessCardDao

    companion object{
        @OptIn(ExperimentalStdlibApi::class)
        @Volatile
        private var INSTANCE: AppDatabase? = null

            fun gatDatabase(context: Context): AppDatabase {
                return INSTANCE ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "businesscard_db"
                    ).build()
                    INSTANCE = instance
                    instance
                }
            }

    }

}