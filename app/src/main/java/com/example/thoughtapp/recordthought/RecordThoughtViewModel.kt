package com.example.thoughtapp.recordthought

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thoughtapp.data.ThoughtRecord
import com.example.thoughtapp.data.ThoughtRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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
                thoughtRepository.getThoughtRecordByIdStream(thoughtId).collect { thoughtRecord ->
                    if (thoughtRecord != null) {
                        _uiState.update { currentState ->
                            Log.d("ViewModelLog", "Updating UI State with: $thoughtRecord")
                            currentState.copy(thoughtRecord = thoughtRecord)

                        }
                        Log.d("ViewModelLog", "Updated UI State with: $thoughtRecord")
                    } else {
                        Log.d("ViewModelLog", "ThoughtRecord is null for ID: $thoughtId")
                    }
                }
            }
        } else {
            Log.d("ViewModelLog", "Invalid thoughtId: $thoughtId")
        }
    }

    fun updateUiState(thoughtRecord: ThoughtRecord) {
        _uiState.update {currentState ->
            currentState.copy(
                thoughtRecord = thoughtRecord
            )
        }
    }

    fun saveNewThoughtRecord() {
        if (validateInput()) {
            viewModelScope.launch(Dispatchers.IO) {
                thoughtRepository.insertThoughtRecord(uiState.value.thoughtRecord)
            }
        }
    }

    /**
     * Checks to see if either the thought or emotion have been filled out.
     * Used to verify user input before adding or updating the entity in the db
     * */
    private fun validateInput(uiState: ThoughtRecord = _uiState.value.thoughtRecord): Boolean {
        return with(uiState) {
            thought.isNotBlank() && emotion.isNotBlank()
        }
    }

}