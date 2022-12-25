package com.lindenlabs.noted.android.screens.show_notes.domain

import com.lindenlabs.noted.data.note.Note

data class NoteListState(
    val notes: List<Note> = emptyList(),
    val searchText: String = "",
    val isSearchActive: Boolean = false
)