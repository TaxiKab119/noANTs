package com.example.thoughtapp.allthoughts


data class ThoughtRecord(
    val id: Int = 0,
    val date: String,
    val situation: String,
    val emotion: String,
    val emotionIntensity: Int,
    val thought: String,
    val thoughtBelief: Int,
)
