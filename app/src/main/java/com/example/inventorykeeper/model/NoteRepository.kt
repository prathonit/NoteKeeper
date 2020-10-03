package com.example.inventorykeeper.model

import android.content.Context
import com.example.inventorykeeper.data.Note

class NoteRepository(application: Context) : NoteDataSource {

    private val noteDao = NoteDatabase.getDatabase(application).noteDao()

    override suspend fun getAllNotes(): List<Note> {
        return noteDao.getAllNotes()
    }

    override suspend fun insert(note: Note) {
        noteDao.insert(note)
    }
}