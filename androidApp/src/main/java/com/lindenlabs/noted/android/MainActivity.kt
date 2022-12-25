package com.lindenlabs.noted.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lindenlabs.noted.android.screens.note_detail.views.NoteDetailView
import com.lindenlabs.noted.android.screens.show_notes.views.NoteListScreen
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { Binding() }
    }

    companion object Binding {

        @Composable
        operator fun invoke() {
            return MyApplicationTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "note_list") {
                    composable(route = "note_list") {
                        NoteListScreen(navController = navController)
                    }
                    composable(
                        route = "note_detail/{noteId}",
                        arguments = listOf(
                            navArgument(name = "noteId") {
                                type = NavType.LongType
                                defaultValue = -1L
                            }
                        )
                    ) { backStackEntry ->
                        val noteId = backStackEntry.toNoteId()
                        NoteDetailView(noteId = noteId, navController = navController)
                    }
                }
            }
        }

        private fun NavBackStackEntry.toNoteId(): Long = arguments?.getLong("noteId") ?: -1L
    }
}