package com.example.ktoractivityex.modelArticle

import kotlinx.serialization.Serializable

@Serializable
data class ModelListItem(
//    val audio: Any,
    val author: String,
//    val category: List<Category>,
//    val category_list: List<CategoryX>,
    val content: String,
    val copyright_text: String,
    val date: String,
    val favorite: Boolean,
    val hide_title: Boolean,
    val id: Int,
    val image: String,
//    val magazin: List<Magazin>,
    val share_text: String,
//    val slug: Any,
    val title: String,
    val url: String,
    val views: String
)