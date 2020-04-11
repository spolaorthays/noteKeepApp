package com.curso.pluralsight.notekeeperapp.ui.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Clicado em Notes Fragment"
    }
    val text: LiveData<String> = _text
}