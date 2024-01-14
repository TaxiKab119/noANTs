package com.example.thoughtapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ThoughtRecord::class], version = 0, exportSchema = false)
abstract class ThoughtsDatabase : RoomDatabase() {
    abstract fun thoughtsDao(): ThoughtsDao

    companion object {
        /**
         * The [Instance] variable keeps a reference to the database when one has been created.
         * This helps maintain a single instance of the database opened at a given time.
         * A database is an expensive resource to maintain.
         * */
        @Volatile // Value of a @Volatile variable is never cached, all reads and writes are to and from main memory
        private var Instance: ThoughtsDatabase? = null
        fun getDatabase(context: Context): ThoughtsDatabase {
            return Instance ?: synchronized(this) {
                // if the Instance is not null, return it, otherwise create a new database instance.
                Room.databaseBuilder(context, ThoughtsDatabase::class.java, "thoughts_database")
                    .build()
                    .also { Instance = it } //keep a reference to the recently created db instance
            }
        }
    }
}