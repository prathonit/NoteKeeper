package com.example.inventorykeeper.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.inventorykeeper.R
import com.example.inventorykeeper.data.Note
import com.example.inventorykeeper.viewmodel.DatabaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_dashboard.*

@AndroidEntryPoint
class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val viewModel by activityViewModels<DatabaseViewModel>()

    private val adapter = NoteAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notes_recycler.adapter = adapter
        viewModel.notes.observe(viewLifecycleOwner, notesObserver)
    }

    private val notesObserver = Observer<List<Note>> {
        adapter.notes = it
    }
}
