package com.lindenlabs.noted.android.screens.show_notes

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.lindenlabs.noted.data.NoteDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShowNotesViewModel @Inject constructor(private val noteDataSource: NoteDataSource, private val savedStateHandle: SavedStateHandle) : ViewModel(){

}
