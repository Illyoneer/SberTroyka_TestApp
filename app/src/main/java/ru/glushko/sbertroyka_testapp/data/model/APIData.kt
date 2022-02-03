package ru.glushko.sbertroyka_testapp.data.model

data class APIData(
    val APIAuthorCompany: APIAuthorCompany,
    val APIAuthors: List<APIAuthor>,
    val description: String,
    val duration: Int,
    val id: Int,
    val img: String,
    val APIRoutes: List<APIRoute>,
    val shortDescription: Any,
    val title: String,
    val type: String
)