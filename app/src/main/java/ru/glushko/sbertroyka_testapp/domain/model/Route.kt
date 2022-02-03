package ru.glushko.sbertroyka_testapp.domain.model

data class Route(
    val galleries: List<Gallery>,
    val media: List<Media>,
    val points: List<Point>,
    val textContents: List<TextContent>,
    val title: String,
    val type: String
)