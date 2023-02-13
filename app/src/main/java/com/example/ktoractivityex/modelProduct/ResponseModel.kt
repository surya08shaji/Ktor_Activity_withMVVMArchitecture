package com.example.ktoractivityex.modelProduct

import kotlinx.serialization.Serializable

@Serializable
data class ResponseModel(
    val title: String,
    val description: String,
    val image: String
)
