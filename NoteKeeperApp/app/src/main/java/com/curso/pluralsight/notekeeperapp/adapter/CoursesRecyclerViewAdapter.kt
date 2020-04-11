package com.curso.pluralsight.notekeeperapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.curso.pluralsight.notekeeperapp.CourseInfo
import com.curso.pluralsight.notekeeperapp.R
import com.curso.pluralsight.notekeeperapp.R.*
import com.curso.pluralsight.notekeeperapp.R.layout.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.item_course_list.view.*

class CoursesRecyclerViewAdapter(private val context: Context, private val listCourses: List<CourseInfo>):
    RecyclerView.Adapter<CoursesRecyclerViewAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = layoutInflater.inflate(item_course_list, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listCourses.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val courseInfo = listCourses[position]
        holder.nameCourse.text = courseInfo.title
        holder.coursePosition = position
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameCourse = itemView.findViewById<TextView>(R.id.nameCourseId)
        var coursePosition = 0
        init {
            itemView.setOnClickListener {
                Toast.makeText(context, listCourses[position].title, Toast.LENGTH_LONG).show()
                //Snackbar(itemView, listCourses[position].title, Snackbar.LENGTH_LONG).show()
            }
        }
    }
}
