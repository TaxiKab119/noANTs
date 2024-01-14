package com.example.thoughtapp.data

import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [ThoughtRecord] from a given data source.
 */
interface ThoughtRepository {
    /**
     * Retrieve all the Thought Records from the the given data source.
     */
    fun getAllThoughtRecordsStream(): Flow<List<ThoughtRecord>>

    /**
     * Retrieve a Thought Record from the given data source that matches with the [id].
     */
    fun getThoughtRecordByIdStream(id: Int): Flow<ThoughtRecord?>

    /**
     * Insert Thought Record in the data source
     */
    suspend fun insertThoughtRecord(thoughtRecord: ThoughtRecord)

    /**
     * Delete ThoughtRecord from the data source
     */
    suspend fun deleteThoughtRecord(thoughtRecord: ThoughtRecord)

    /**
     * Update ThoughtRecord in the data source
     */
    suspend fun updateThoughtRecord(thoughtRecord: ThoughtRecord)
}