package com.example.thoughtapp.landing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thoughtapp.allthoughts.AllThoughtsUiState
import com.example.thoughtapp.data.ThoughtRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


class LandingViewModel(thoughtRepository: ThoughtRepository) : ViewModel() {
    val thoughtsCount: StateFlow<Int> =
        thoughtRepository.getAllThoughtRecordsStream()
            .map { it.size } // Map the list to its size
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = 0
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}