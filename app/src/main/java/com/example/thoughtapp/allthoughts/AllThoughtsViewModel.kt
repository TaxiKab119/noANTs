package com.example.thoughtapp.allthoughts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thoughtapp.data.ThoughtRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class AllThoughtsViewModel(thoughtRepository: ThoughtRepository): ViewModel() {
    val uiState: StateFlow<AllThoughtsUiState> =
        thoughtRepository.getAllThoughtRecordsStream().map { AllThoughtsUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = AllThoughtsUiState(isLoading = true),
            )
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

}