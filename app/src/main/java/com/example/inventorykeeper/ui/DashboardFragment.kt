package com.example.inventorykeeper.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.inventorykeeper.R
import com.example.inventorykeeper.helper.NoteAdapter
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val viewModel by activityViewModels<DatabaseViewModel>()

    private val adapter = NoteAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notes_recycler.adapter = adapter
        viewModel.allNotes.observe(viewLifecycleOwner, Observer {notes ->
            notes?.let {
                adapter.notes = notes
            }
        })
    }
}
