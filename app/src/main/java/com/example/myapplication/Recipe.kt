package com.example.myapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val mealType: String,
    val serves: Int,
    val difficulty: String,
    val ingredients: String,
    val preparationSteps: String
)
