package com.example.animalcrossing.ui.insect

interface InsectRepository {
    fun giveHello(): String
}

class InsectRepositoryImpl : InsectRepository {
    override fun giveHello() = "Hello Koin"
}