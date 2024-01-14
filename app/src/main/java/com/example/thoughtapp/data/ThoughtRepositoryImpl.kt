package com.example.thoughtapp.data

import kotlinx.coroutines.flow.Flow

class ThoughtRepositoryImpl(private val thoughtsDao: ThoughtsDao) : ThoughtRepository {
    /**
     * Retrieve all the Thought Records from the the given data source.
     */
    override fun getAllThoughtRecordsStream(): Flow<List<ThoughtRecord>> {
        return thoughtsDao.getAllThoughtRecords()
    }

    /**
     * Retrieve a Thought Record from the given data source that matches with the [id].
     */
    override fun getThoughtRecordByIdStream(id: Int): Flow<ThoughtRecord?> {
        return thoughtsDao.findThoughtRecordById(id)
    }

    /**
     * Insert Thought Record in the data source
     */
    override suspend fun insertThoughtRecord(thoughtRecord: ThoughtRecord) {
        return thoughtsDao.insertThoughtRecord(thoughtRecord)
    }

    /**
     * Delete ThoughtRecord from the data source
     */
    override suspend fun deleteThoughtRecord(thoughtRecord: ThoughtRecord) {
        return thoughtsDao.deleteThoughtRecord(thoughtRecord)
    }

    /**
     * Update ThoughtRecord in the data source
     */
    override suspend fun updateThoughtRecord(thoughtRecord: ThoughtRecord) {
        return thoughtsDao.updateThoughtRecord(thoughtRecord)
    }

}