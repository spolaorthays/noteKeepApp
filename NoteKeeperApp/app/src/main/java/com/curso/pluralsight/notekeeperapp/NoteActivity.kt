package com.curso.pluralsight.notekeeperapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter

import kotlinx.android.synthetic.main.activity_note.*
import kotlinx.android.synthetic.main.content_main.*

class NoteActivity : AppCompatActivity() {

    private var notePosition = POSITION_NOT_SET

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)
        setSupportActionBar(toolbar)

        val adapterCourses = ArrayAdapter<CourseInfo>(this, android.R.layout.simple_spinner_item,
            DataManager.courses.values.toList())
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerId.adapter = adapterCourses

        notePosition = savedInstanceState?.getInt(NOTE_POSITION, POSITION_NOT_SET) ?:
                intent.getIntExtra(NOTE_POSITION, POSITION_NOT_SET)

        if (notePosition != POSITION_NOT_SET){
            displayNote()
        } else {
            DataManager.notes.add(NoteInfo())
            notePosition = DataManager.notes.lastIndex
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(NOTE_POSITION, notePosition)
    }

    //Esse método mostra os dados na nota que foi clicada e deixa o spinner na posição de acordo com a nota também
    private fun displayNote() {
        val note = DataManager.notes[notePosition]
        noteTitleId.setText(note.title)
        noteTextId.setText(note.text)

        val coursePosition = DataManager.courses.values.indexOf(note.course)
        spinnerId.setSelection(coursePosition)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.action_next -> {
                moveNext()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun moveNext() {
        notePosition++
        displayNote()
        //Toda vez que for mudar de nota, esse método chama o onPrepareOptionMenu para executar suas ações
        invalidateOptionsMenu()
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if (notePosition >= DataManager.notes.lastIndex){
            val menuItem = menu?.findItem(R.id.action_next)
            if (menuItem != null){
                menuItem.icon = getDrawable(R.drawable.ic_block_white_24dp)
                menuItem.isEnabled = false
            }

        }
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onPause() {
        super.onPause()

        saveNote()
    }

    //O dado novo fica salvo, pois não estamos destruindo a activity em questão.
    private fun saveNote() {
        val note = DataManager.notes[notePosition]
        note.title = noteTitleId.text.toString()
        note.text = noteTextId.text.toString()
        note.course = spinnerId.selectedItem as CourseInfo
    }
}
