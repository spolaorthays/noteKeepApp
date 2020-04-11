package com.curso.pluralsight.notekeeperapp.ui.courses

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CoursesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Clicado em Cursos Fragment"
    }
    val text: LiveData<String> = _text
}