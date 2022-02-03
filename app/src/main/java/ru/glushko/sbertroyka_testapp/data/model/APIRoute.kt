package ru.glushko.sbertroyka_testapp.data.model

data class APIRoute(
    val audio: String,
    val APIGalleries: List<APIGallery>,
    val APIMedia: List<APIMedia>,
    val APIPoints: List<APIPoint>,
    val APITextContents: List<APITextContent>,
    val title: String,
    val type: String
)