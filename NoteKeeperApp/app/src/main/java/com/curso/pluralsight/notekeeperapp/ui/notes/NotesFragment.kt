package com.curso.pluralsight.notekeeperapp.ui.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.curso.pluralsight.notekeeperapp.DataManager
import com.curso.pluralsight.notekeeperapp.adapter.NotesRecyclerViewAdapter
import com.curso.pluralsight.notekeeperapp.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_notes.*

class NotesFragment : Fragment() {

    private lateinit var noteViewModel: NotesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        noteViewModel = ViewModelProviders.of(this).get(NotesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notes, container, false)
        noteViewModel.text.observe(viewLifecycleOwner, Observer {
            //Snackbar.make(root, it, Snackbar.LENGTH_LONG).show()
            recyclerViewNotes.adapter = NotesRecyclerViewAdapter(context!!, DataManager.notes)
            recyclerViewNotes.layoutManager = LinearLayoutManager(context)
        })
        return root
    }

    override fun onResume() {
        super.onResume()

        recyclerViewNotes.adapter?.notifyDataSetChanged()
    }
}
