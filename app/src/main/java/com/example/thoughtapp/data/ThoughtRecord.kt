package com.example.thoughtapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "thoughts")
data class ThoughtRecord(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val situation: String = "",
    val emotion: String = "",
    @ColumnInfo("emotion_intensity") val emotionIntensity: Int = 50,
    val thought: String = "",
    @ColumnInfo("thought_belief") val thoughtBelief: Int = 50,
    @ColumnInfo("true_because") val trueBecause: String = "",
    @ColumnInfo("false_because") val falseBecause: String = "",
    val reconsider: String = "",
    @ColumnInfo("reconsider_belief") val reconsiderationBelief: Int = 50
) {
    companion object {
        // Default instance of ThoughtRecord with default values
        val default = ThoughtRecord()
    }
}
