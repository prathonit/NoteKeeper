package com.example.inventorykeeper.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inventorykeeper.data.Note
import com.example.inventorykeeper.model.NoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DatabaseViewModel @ViewModelInject constructor(private val repository: NoteDataSource) :
    ViewModel() {

    private val _notes: MutableLiveData<List<Note>> = MutableLiveData()
    val notes: LiveData<List<Note>>
        get() = _notes

    private fun getNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            _notes.postValue(repository.getAllNotes())
        }
    }

    fun insert(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
        getNotes()
    }

    init {
        getNotes()
    }
}