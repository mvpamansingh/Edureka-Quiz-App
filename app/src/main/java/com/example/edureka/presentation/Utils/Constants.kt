package com.example.edureka.presentation.Utils

object Constants {

    val numberAsString = listOf("10") + (1..50).map { it.toString() }



    val categories  = listOf(
        "General Knowledge",

        "Entertainment: Books",
        "Entertainment: Films",
        "Entertainment: Music",
        "Entertainment: Musicals & Theatres",
        "Entertainment: Television",
        "Entertainment: Video Games",
        "Entertainment: Board Games",
        "Science & nature",
        "Science: Computers",
        "Science: Mathematics",
        "Mythology",
        "Sports",
        "Geography",
        "History",
        "Politics",
        "Art",
        "Celebrities",
        "Animals",
        "Vehicles",
        "Entertainment: Comics",
        "Science: Gadgets",
        "Entertainment: Japanese Anime & Manga",
        "Entertainment: Cartoon & Animations"
    )

    val categoriesMap= mapOf(
        "General Knowledge" to 9,
        "Entertainment: Books" to 10,
        "Entertainment: Films" to 11,
        "Entertainment: Music" to 12,
        "Entertainment: Musicals & Theatres" to 13,
        "Entertainment: Television" to 14,
        "Entertainment: Video Games" to 15,
        "Entertainment: Board Games" to 16,


        "Science & nature" to 17,

        "Science: Computers" to 18,
        "Science: Mathematics" to 19,
        "Mythology" to 20,

        "Sports" to  21,

        "Geography" to 22,

        "History" to 23,

        "Politics" to 24,

        "Art" to 25,

        "Celebrities" to 26,

        "Animals" to 27,

        "Vehicle" to 28,

        "Entertainment: Comics" to 29,

        "Science: Gadgets" to 30,

        "Entertainment: Japanese Anime & Manga" to 31,

        "Entertainment: Cartoon & Animations" to 32,

        )

    val difficulty = listOf("Easy", "Medium", "Hard")
    val type = listOf("Multiple Choice","True Or False"  )
}