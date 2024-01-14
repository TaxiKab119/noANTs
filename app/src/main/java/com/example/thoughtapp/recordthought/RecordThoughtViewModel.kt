package com.example.thoughtapp.recordthought

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thoughtapp.data.ThoughtRecord
import com.example.thoughtapp.data.ThoughtRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RecordThoughtViewModel(
    private val thoughtId: Int,
    private val thoughtRepository: ThoughtRepository
): ViewModel() {

    /**
     * This first block sets up the ui state to be mutable initializes participant list
     * */
    private val _uiState = MutableStateFlow(
        RecordThoughtUiState()
    )
    val uiState: StateFlow<RecordThoughtUiState> = _uiState

    init {
        if (thoughtId != 0) {
            viewModelScope.launch(Dispatchers.IO) {
                thoughtRepository.getThoughtRecordByIdStream(thoughtId).mapNotNull { thoughtRecord ->
                    _uiState.update { currentState ->
                        currentState.copy(
                            thoughtRecord = thoughtRecord!!,
                        )
                    }
                }
            }
        }
    }

    fun updateUiState(thoughtRecord: ThoughtRecord) {
        _uiState.update {currentState ->
            currentState.copy(
                thoughtRecord = thoughtRecord
            )
        }
    }


}