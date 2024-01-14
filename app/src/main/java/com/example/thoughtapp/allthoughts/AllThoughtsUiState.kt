package com.example.thoughtapp.allthoughts

import com.example.thoughtapp.data.ThoughtRecord

data class AllThoughtsUiState (
    val thoughtsList: List<ThoughtRecord> = listOf(),
    val isLoading: Boolean = false
)


