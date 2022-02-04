package ru.glushko.sbertroyka_testapp.domain.model

data class Gallery(
    val ordering: Int, //Очередность изображений
    val value: List<String> //Ссылки на изображения
)