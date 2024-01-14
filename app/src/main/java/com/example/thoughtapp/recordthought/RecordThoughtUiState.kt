package com.example.thoughtapp.recordthought

import com.example.thoughtapp.data.ThoughtRecord

data class RecordThoughtUiState(
    val thoughtRecord: ThoughtRecord = ThoughtRecord(),
    val haveFieldsBeenPopulated: Boolean = false,
)
