package com.example.thoughtapp

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.thoughtapp.allthoughts.AllThoughtsViewModel

object AppViewModelProvider {
    fun thoughtsViewModelFactory() = viewModelFactory {
        initializer {
            AllThoughtsViewModel(
                thoughtsApplication().container.thoughtRepository
            )
        }

    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [ThoughtsApplication].
 */
fun CreationExtras.thoughtsApplication(): ThoughtsApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as ThoughtsApplication)