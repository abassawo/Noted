package com.lindenlabs.noted.android.base.di

import android.app.Application
import com.lindenlabs.noted.AppDataSource
import com.lindenlabs.noted.data.NoteDataSource
import com.lindenlabs.noted.data.local.DatabaseDriverFactory
import com.lindenlabs.noted.database.NoteDatabase
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).createDriver()
    }

    @Provides
    @Singleton
    fun provideNoteDataSource(driver: SqlDriver): NoteDataSource {
        return AppDataSource(NoteDatabase(driver))
    }
}