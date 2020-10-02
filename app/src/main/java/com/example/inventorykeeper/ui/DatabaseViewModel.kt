package com.example.inventorykeeper.ui

import android.app.Application
import androidx.lifecycle.*
import com.example.inventorykeeper.helper.Note
import com.example.inventorykeeper.helper.NoteDatabase
import com.example.inventorykeeper.helper.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DatabaseViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: NoteRepository
    val allNotes: LiveData<List<Note>>

    init {
        val noteDao = NoteDatabase.getDatabase(application).noteDao()
        repository = NoteRepository(noteDao)
        allNotes = repository.allNotes
    }

    fun insert(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }

    fun delete(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }

}