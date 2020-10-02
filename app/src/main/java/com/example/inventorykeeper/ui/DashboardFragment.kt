package com.example.inventorykeeper.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inventorykeeper.R
import com.example.inventorykeeper.databinding.FragmentDashboardBinding
import com.example.inventorykeeper.helper.NoteAdapter

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DatabaseViewModel

    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel = ViewModelProvider(this).get(DatabaseViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)

        val adapter = NoteAdapter(requireContext())
        binding.notesRecycler.adapter = adapter
        binding.notesRecycler.layoutManager = LinearLayoutManager(requireContext())

        dashboardViewModel.allNotes.observe(viewLifecycleOwner, Observer {notes ->
            notes?.let {
                adapter.setNotes(notes)
            }
        })

        return binding.root
    }
}
