package com.example.roomdblearningapp

import android.app.Application
import com.example.roomdblearningapp.data.WordRoomDatabase
import com.example.roomdblearningapp.repository.WordRepository

class WordApplication : Application() {

    val database by lazy { WordRoomDatabase.getInstance(applicationContext) }
    val repository by lazy { WordRepository(database.wordDao()) }
}