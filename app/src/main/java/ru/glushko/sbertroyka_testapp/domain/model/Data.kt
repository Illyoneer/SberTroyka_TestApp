package ru.glushko.sbertroyka_testapp.domain.model

data class Data(
    val authorCompany: AuthorCompany,
    val authors: List<Author>,
    val description: String,
    val duration: Int,
    val id: Int,
    val img: String,
    val routes: List<Route>,
    val shortDescription: Any,
    val title: String,
    val type: String
)