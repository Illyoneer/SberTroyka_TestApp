package ru.glushko.sbertroyka_testapp.data.model

data class APIGallery(
    val caption: Any,
    val ordering: Int,
    val type: String,
    val value: List<String>
)