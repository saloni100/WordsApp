package com.example.roomdblearningapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdblearningapp.data.Word
import com.example.roomdblearningapp.repository.WordRepository
import kotlinx.coroutines.launch

class WordViewModel(private val wordRepository: WordRepository) : ViewModel() {

    val allWords : LiveData<List<Word>> = wordRepository.allWords.asLiveData()


    fun insertWord(word : Word) {
        viewModelScope.launch {
            wordRepository.insertWord(word)
        }
    }
}