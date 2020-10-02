package com.example.inventorykeeper.model

import androidx.room.*
import com.example.inventorykeeper.data.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes_table ORDER BY date DESC")
    fun getAllNotes(): List<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

}