package com.lindenlabs.webapp

import com.lindenlabs.noted.data.note.Note
import com.lindenlabs.noted.database.NoteDatabase

interface NoteStoreContract {
    interface View {
        fun showNotes(notes: List<Note>)
        fun showLoader()
        fun hideLoader()
    }
    interface Presenter {
        fun attach(view: View)
        fun loadNotes()
    }
}

class NotesPresenter : NoteStoreContract.Presenter {
    private lateinit var view: NoteStoreContract.View
    private val appDataSource:
    override fun attach(view: NoteStoreContract.View) {
        this.view = view
        loadNotes()
    }

    override fun loadNotes() {
        view.showLoader()
        getNotes()
    }

}
