package com.example.swiftpay.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Country(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val flag: Int,
    var isSelected: Boolean = false
)