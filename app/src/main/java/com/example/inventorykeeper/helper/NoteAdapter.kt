package com.example.inventorykeeper.helper

import android.content.Context
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.inventorykeeper.R

class NoteAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var notes = emptyList<Note>()

    private val dateFormat = DateFormat.getDateFormat(context)

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteTitleText: TextView = itemView.findViewById(R.id.note_title_text)
        val noteBodyText: TextView = itemView.findViewById(R.id.note_body_text)
        val noteDateText: TextView = itemView.findViewById(R.id.note_date_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = inflater.inflate(R.layout.note_list_item, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]

        holder.noteTitleText.text = note.title
        holder.noteBodyText.text = note.body
        holder.noteDateText.text = dateFormat.format(note.date)
    }

    internal fun setNotes(notes: List<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = notes.size

}