package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.ui.screens.BookmarksScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.QuizScreen
import com.example.ui.screens.ResultScreen
import com.example.ui.theme.RajasthanQuizTheme
import com.example.ui.viewmodel.QuizViewModel
import com.example.ui.viewmodel.Screen

class MainActivity : ComponentActivity() {

    private val viewModel: QuizViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RajasthanQuizTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    QuizAppRoot(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun QuizAppRoot(viewModel: QuizViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState.currentScreen) {
        Screen.HOME -> HomeScreen(uiState = uiState, viewModel = viewModel)
        Screen.QUIZ -> QuizScreen(uiState = uiState, viewModel = viewModel)
        Screen.RESULT -> ResultScreen(uiState = uiState, viewModel = viewModel)
        Screen.BOOKMARKS -> BookmarksScreen(uiState = uiState, viewModel = viewModel)
    }
}
