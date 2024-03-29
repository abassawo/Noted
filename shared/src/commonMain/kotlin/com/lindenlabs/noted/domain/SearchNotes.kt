package com.lindenlabs.noted.domain

import com.lindenlabs.noted.data.note.Note
import com.lindenlabs.noted.utils.DateTimeUtil

class SearchNotes {

    operator fun invoke(notes: List<Note>, query: String): List<Note> {
        if(query.isBlank()) {
            return notes
        }
        return notes.filter {
            it.title.trim().lowercase().contains(query.lowercase()) ||
                    it.content.trim().lowercase().contains(query.lowercase())
        }.sortedBy {
            DateTimeUtil.toEpochMillis(it.created)
        }
    }
}