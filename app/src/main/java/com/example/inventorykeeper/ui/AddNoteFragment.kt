package com.example.inventorykeeper.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.inventorykeeper.R
import com.example.inventorykeeper.helper.Note
import kotlinx.android.synthetic.main.fragment_add_note.*
import java.util.*

class AddNoteFragment : Fragment(R.layout.fragment_add_note) {

    private val viewModel by activityViewModels<DatabaseViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        add_note_button.setOnClickListener {
            var title = "Untitled"
            var body = "No body"
            if(!title_edit.text.isNullOrBlank())
                title = title_edit.text.toString()
            if(!body_edit.text.isNullOrBlank())
                body = body_edit.text.toString()
            viewModel.insert(Note(
                0,
                title,
                body,
                Date().time
            ))
        }
    }
}
