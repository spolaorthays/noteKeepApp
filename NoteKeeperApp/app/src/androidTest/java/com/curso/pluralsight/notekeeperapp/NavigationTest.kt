package com.curso.pluralsight.notekeeperapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.NavigationViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.runner.RunWith
import androidx.test.rule.ActivityTestRule
import com.curso.pluralsight.notekeeperapp.adapter.CoursesRecyclerViewAdapter
import com.curso.pluralsight.notekeeperapp.adapter.NotesRecyclerViewAdapter
import org.junit.Rule
import org.junit.Test
import org.junit.matchers.JUnitMatchers.containsString

@RunWith(AndroidJUnit4::class)
class NavigationTest{

    @Rule //Faz com que essa propriedade seja visível pro JUnit
    @JvmField //Como o java apresenta as propriedades diferente do kotlin, é necessária essa notação também para esta propriedade ser lida corretamente no teste
    val itensActivity = ActivityTestRule(ItensActivity::class.java)

    @Test  //Faz a função ser visível no teste
    fun selectNoteAfterNavigationDrawerChange(){
        //Essa primeira parte abre a aba de cursos e clica no primeiro curso
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open())
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_courses))

        val coursePosition = 0
        onView(withId(R.id.recyclerViewCourses)).perform(RecyclerViewActions.actionOnItemAtPosition<
                CoursesRecyclerViewAdapter.ViewHolder>(coursePosition, click())
        )

        //Essa parte abre a aba de notas e clica na primeira nota
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open())
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_notes))

        val notePosition = 0
        onView(withId(R.id.recyclerViewNotes)).perform(RecyclerViewActions.actionOnItemAtPosition<
                NotesRecyclerViewAdapter.ViewHolder>(notePosition, click())
        )

        //Essa parte verifica se a nota clicada está com o curso, titulo e texto selecionado corretamente
        val note = DataManager.notes[notePosition]
        onView(withId(R.id.spinnerId)).check(matches(withSpinnerText(containsString(note.course?.title))))
        onView(withId(R.id.noteTitleId)).check(matches(withText(containsString(note.title))))
        onView(withId(R.id.noteTextId)).check(matches(withText(containsString(note.text))))
    }
}