package com.example.inventorykeeper.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inventorykeeper.R
import com.example.inventorykeeper.helper.NoteAdapter
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val viewModel by activityViewModels<DatabaseViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = NoteAdapter(requireContext())
        notes_recycler.adapter = adapter
        notes_recycler.layoutManager = LinearLayoutManager(requireContext())

        viewModel.allNotes.observe(viewLifecycleOwner, Observer {notes ->
            notes?.let {
                adapter.setNotes(notes)
            }
        })
    }
}
