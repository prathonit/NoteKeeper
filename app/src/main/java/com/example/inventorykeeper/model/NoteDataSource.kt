package com.example.inventorykeeper.model

import com.example.inventorykeeper.data.Note

interface NoteDataSource {

    suspend fun getAllNotes(): List<Note>

    suspend fun insert(note: Note)
}