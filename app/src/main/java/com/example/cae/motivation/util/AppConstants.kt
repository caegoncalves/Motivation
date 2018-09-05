package com.example.cae.motivation.util

class AppConstants private constructor(){ //como a classe não vai ter métodos e não vai ser instanciada, usa-se o construtor privado

    object KEY {
        val PERSON_NAME = "person name"
    }

    object PHRASE_FILTER {
        val ALL = 1
        val SUN = 2
        val HAPPY = 3
    }
}