package com.lindenlabs.noted.di

import com.lindenlabs.noted.data.local.DatabaseDriverFactory
import com.lindenlabs.noted.data.note.AppDataSource
import com.lindenlabs.noted.data.note.NoteDataSource
import com.lindenlabs.noted.database.NoteDatabase

class DatabaseModule {

    private val factory by lazy { DatabaseDriverFactory() }
    val noteDataSource: NoteDataSource by lazy {
        AppDataSource(NoteDatabase(factory.createDriver()))
    }
}