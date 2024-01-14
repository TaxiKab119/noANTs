package com.example.thoughtapp.allthoughts


data class ThoughtRecord(
    val id: Int = 0,
    val situation: String = "",
    val emotion: String = "",
    val emotionIntensity: Int = 50,
    val thought: String = "",
    val thoughtBelief: Int = 50,
    val trueBecause: String = "",
    val falseBecause: String = "",
    val reconsider: String = "",
    val reconsiderationBelief: Int = 50
) {
    companion object {
        // Default instance of ThoughtRecord with default values
        val default = ThoughtRecord()
    }
}
