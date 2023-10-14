package com.example.roomdblearningapp.repository

import androidx.annotation.WorkerThread
import com.example.roomdblearningapp.data.Word
import com.example.roomdblearningapp.data.WordDao
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {

    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @WorkerThread
    suspend fun insertWord(word : Word) {
        wordDao.insertWord(word)
    }
}