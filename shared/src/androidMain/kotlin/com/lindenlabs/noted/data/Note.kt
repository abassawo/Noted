package com.lindenlabs.noted.data

import com.lindenlabs.noted.presentation.BabyBlueHex
import com.lindenlabs.noted.presentation.LightGreenHex
import com.lindenlabs.noted.presentation.RedOrangeHex
import com.lindenlabs.noted.presentation.RedPinkHex
import com.lindenlabs.noted.presentation.VioletHex
import database.NoteEntity
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

data class Note(
    val id: Long?,
    val title: String,
    val content: String,
    val colorHex: Long,
    val created: LocalDateTime
) {
    companion object {
        private val colors = listOf(RedOrangeHex, RedPinkHex, LightGreenHex, BabyBlueHex, VioletHex)

        fun generateRandomColor() = colors.random()

        fun fromNoteEntity(noteEntity: NoteEntity): Note {
            return with(noteEntity) {
                Note(
                    id = id,
                    title = title,
                    content = content,
                    colorHex = colorHex,
                    created = Instant
                        .fromEpochMilliseconds(created)
                        .toLocalDateTime(TimeZone.currentSystemDefault())
                )
            }
        }
    }
}