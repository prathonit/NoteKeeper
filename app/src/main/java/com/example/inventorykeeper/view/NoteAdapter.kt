package com.example.inventorykeeper.view

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.inventorykeeper.R
import com.example.inventorykeeper.data.Note

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    var notes = emptyList<Note>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private lateinit var dateFormat: java.text.DateFormat

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteTitleText: TextView = itemView.findViewById(R.id.note_title_text)
        val noteBodyText: TextView = itemView.findViewById(R.id.note_body_text)
        val noteDateText: TextView = itemView.findViewById(R.id.note_date_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        dateFormat = DateFormat.getDateFormat(parent.context)
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]

        holder.noteTitleText.text = note.title
        holder.noteBodyText.text = note.body
        holder.noteDateText.text = dateFormat.format(note.date)
    }

    override fun getItemCount(): Int = notes.size
}