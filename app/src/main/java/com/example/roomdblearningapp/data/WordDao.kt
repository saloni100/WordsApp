package com.example.roomdblearningapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    @Query("select *  FROM word_table ORDER BY word Asc")
    fun getAlphabetizedWords() : Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertWord(word : Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}