package com.curso.pluralsight.notekeeperapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.curso.pluralsight.notekeeperapp.NOTE_POSITION
import com.curso.pluralsight.notekeeperapp.NoteActivity
import com.curso.pluralsight.notekeeperapp.NoteInfo
import com.curso.pluralsight.notekeeperapp.R
import kotlinx.android.synthetic.main.item_note_list.view.*

class NotesRecyclerViewAdapter(private val context: Context, private val listNotes: List<NoteInfo>): RecyclerView.Adapter<NotesRecyclerViewAdapter.ViewHolder>(){

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = layoutInflater.inflate(R.layout.item_note_list, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listNotes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val noteInfo = listNotes[position]

        holder.bind(noteInfo, position)
    }

    //Se declararmos o ViewHolder como inner, permitimos que essa classe tenha acesso aos membros do Adapter, se não fizer isso, eu teria que acessar o contexto pelo itemView
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(noteInfo: NoteInfo, position: Int){
            itemView.nomeCursoId.text = noteInfo.course!!.title
            itemView.tituloNotaId.text = noteInfo.title
            itemView.textoNotaId.text = noteInfo.text

            itemView.setOnClickListener {
                val intent = Intent(context, NoteActivity::class.java)
                intent.putExtra(NOTE_POSITION, position)
                context.startActivity(intent)
            }
        }
    }
}