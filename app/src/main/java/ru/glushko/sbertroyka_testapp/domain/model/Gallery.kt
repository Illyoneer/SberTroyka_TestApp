package ru.glushko.sbertroyka_testapp.domain.model

data class Gallery(
    val caption: Any,
    val ordering: Int,
    val type: String,
    val value: List<String>
)