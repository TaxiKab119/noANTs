package com.example.thoughtapp.di

import android.content.Context
import com.example.thoughtapp.data.ThoughtRepository
import com.example.thoughtapp.data.ThoughtRepositoryImpl
import com.example.thoughtapp.data.ThoughtsDatabase

/**
 * App container for Dependency injection
 */
interface AppContainer {
    val thoughtRepository: ThoughtRepository
}

/**
 * [AppContainer] implementation that provides instance of [ThoughtRepositoryImpl]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [ThoughtRepository]
     */
    override val thoughtRepository: ThoughtRepository by lazy {
        ThoughtRepositoryImpl(ThoughtsDatabase.getDatabase(context).thoughtsDao())
    }
}