package com.example.thoughtapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ThoughtsDao {
    @Query("SELECT * FROM thoughts")
    fun getAllThoughtRecords(): Flow<List<ThoughtRecord>>

    @Query("SELECT * FROM thoughts WHERE id = :id")
    fun findThoughtRecordById(id: Int): Flow<ThoughtRecord>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertThoughtRecord(thoughtRecord: ThoughtRecord)

    @Update
    suspend fun updateThoughtRecord(thoughtRecord: ThoughtRecord)

    @Delete
    suspend fun deleteThoughtRecord(thoughtRecord: ThoughtRecord)
}