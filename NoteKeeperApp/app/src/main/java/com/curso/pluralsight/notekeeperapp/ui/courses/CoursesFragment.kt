package com.curso.pluralsight.notekeeperapp.ui.courses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.curso.pluralsight.notekeeperapp.DataManager
import com.curso.pluralsight.notekeeperapp.R
import com.curso.pluralsight.notekeeperapp.adapter.CoursesRecyclerViewAdapter
import com.curso.pluralsight.notekeeperapp.adapter.NotesRecyclerViewAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_courses.*
import kotlinx.android.synthetic.main.fragment_notes.*

class CoursesFragment : Fragment() {

    private lateinit var coursesViewModel: CoursesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        coursesViewModel = ViewModelProviders.of(this).get(CoursesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_courses, container, false)
        coursesViewModel.text.observe(viewLifecycleOwner, Observer {
            //Snackbar.make(root, it, Snackbar.LENGTH_LONG).show()
            recyclerViewCourses.adapter = CoursesRecyclerViewAdapter(context!!, DataManager.courses.values.toList())
            recyclerViewCourses.layoutManager = GridLayoutManager(context, 2)
        })
        return root
    }

    override fun onResume() {
        super.onResume()

        recyclerViewCourses.adapter?.notifyDataSetChanged()
    }
}
