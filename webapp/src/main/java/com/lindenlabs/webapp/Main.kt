package com.lindenlabs.webapp

fun main() {
    val allNotesPresenter = NotesPresenter()
    val notesPage = NotePage(allNotesPresenter)
    notesPage.show()
}