package com.curso.pluralsight.notekeeperapp

//Declarando como object ao invés de class, eu transformo o Data Manager em um Singleton e isso faz
// com que se tenha apenas uma instância desse objeto no app, mesmo que ele seja trabalho em activitys diferentes.
object DataManager {

    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
        initializeNotes()
    }

    private fun initializeCourses(){
        var course = CourseInfo("android_intents", "Android Programming with Intents")
        courses.set(course.courseId, course)

        course = CourseInfo("android_sync", "Android Async Programming and Services")
        courses.set(course.courseId, course)

        course = CourseInfo(title = "Java Fundamentals", courseId = "java_lang")
        courses.set(course.courseId, course)

        course = CourseInfo("java_core", "Java Fundamentals: The Core Plataform")
        courses.set(course.courseId, course)
    }

    fun initializeNotes(){
        var note = NoteInfo(CourseInfo("java_core", "Java Fundamentals: The Core Plataform"), "Curso de Java", "Curso de java básico")
        notes.add(note)

        note = NoteInfo(CourseInfo("java_lang", "Java Fundamentals"), "Curso de Java2", "Curso de java intermediário")
        notes.add(note)

        note = NoteInfo(CourseInfo("java_lang", "Java Fundamentals"), "Curso de Java3", "Curso de java intermediário")
        notes.add(note)

        note = NoteInfo(CourseInfo("java_lang", "Java Fundamentals"), "Curso de Java4", "Curso de java intermediário")
        notes.add(note)

        note = NoteInfo(CourseInfo("java_lang", "Java Fundamentals"), "Curso de Java5", "Curso de java intermediário")
        notes.add(note)

        note = NoteInfo(CourseInfo("java_lang", "Java Fundamentals"), "Curso de Java6", "Curso de java intermediário")
        notes.add(note)
    }
}