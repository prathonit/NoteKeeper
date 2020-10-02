package com.example.inventorykeeper.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.inventorykeeper.R
import com.example.inventorykeeper.databinding.FragmentAddNoteBinding
import com.example.inventorykeeper.helper.Note
import java.util.*

class AddNoteFragment : Fragment() {

    private lateinit var databaseViewModel: DatabaseViewModel

    private lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        databaseViewModel = ViewModelProvider(this).get(DatabaseViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_note, container, false)

        binding.addNoteButton.setOnClickListener {
            var title = "Untitled"
            var body = "No body"
            if(!binding.titleEdit.text.isNullOrBlank())
                title = binding.titleEdit.text.toString()
            if(!binding.bodyEdit.text.isNullOrBlank())
                body = binding.bodyEdit.text.toString()
            databaseViewModel.insert(Note(
                0,
                title,
                body,
                Date().time
            ))
        }

        return binding.root
    }
}
