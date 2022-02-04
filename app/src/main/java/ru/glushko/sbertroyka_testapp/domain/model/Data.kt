package ru.glushko.sbertroyka_testapp.domain.model

data class Data(
    val authorCompany: AuthorCompany, //Хз что это)
    val authors: List<Author>, //Авторы прогулки
    val description: String, //Описание прогулки
    val duration: Int, //Длительность - в минутах
    val id: Int, //Тут и так понятно, хз зачем она сейчас..
    val img: String, //Картинка для карточки
    val routes: List<Route>, //Точки маршрута
    val title: String, //Название прогулки
    val type: String //В нашем случае - всегда пешеходная, но можно обработать
)