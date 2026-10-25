package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Question
import com.example.data.model.QuizMode
import com.example.ui.theme.CorrectGreen
import com.example.ui.theme.CorrectGreenContainer
import com.example.ui.theme.WrongRed
import com.example.ui.theme.WrongRedContainer
import com.example.ui.viewmodel.QuizUiState
import com.example.ui.viewmodel.QuizViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(
    uiState: QuizUiState,
    viewModel: QuizViewModel
) {
    val session = uiState.session
    val questions = session.questions
    val currentIndex = session.currentIndex

    var showExitDialog by remember { mutableStateOf(false) }
    var showSubmitDialog by remember { mutableStateOf(false) }
    var showPaletteSheet by remember { mutableStateOf(false) }

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    BackHandler {
        showExitDialog = true
    }

    if (questions.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "कोई प्रश्न उपलब्ध नहीं है")
        }
        return
    }

    val currentQuestion = questions[currentIndex]
    val selectedOptionIndex = session.userAnswers[currentQuestion.id]
    val isAnswered = selectedOptionIndex != null
    val isBookmarked = session.bookmarkedIds.contains(currentQuestion.id)
    val progress = (currentIndex + 1).toFloat() / questions.size

    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    title = {
                        Column {
                            Text(
                                text = "प्रश्न ${currentIndex + 1} / ${questions.size}",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                            Text(
                                text = currentQuestion.category.displayName,
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.85f)
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = { showExitDialog = true },
                            modifier = Modifier.testTag("quiz_back_button")
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "क्विज़ छोड़ें",
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = { viewModel.toggleBookmark(currentQuestion.id) },
                            modifier = Modifier.testTag("quiz_bookmark_button")
                        ) {
                            Icon(
                                imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                                contentDescription = "बुकमार्क",
                                tint = if (isBookmarked) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onPrimary
                            )
                        }
                        IconButton(
                            onClick = { showPaletteSheet = true },
                            modifier = Modifier.testTag("quiz_palette_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.GridView,
                                contentDescription = "सभी प्रश्न",
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                        Button(
                            onClick = { showSubmitDialog = true },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.secondary,
                                contentColor = MaterialTheme.colorScheme.onSecondary
                            ),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .testTag("submit_early_button")
                        ) {
                            Text(
                                text = "सबमिट",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )

                LinearProgressIndicator(
                    progress = { progress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp),
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
                )

                // Question Countdown Timer Bar
                if (session.timerSecondsPerQuestion > 0) {
                    val remaining = session.remainingSeconds
                    val totalSec = session.timerSecondsPerQuestion
                    val timerFraction = (remaining.toFloat() / totalSec).coerceIn(0f, 1f)
                    val isCritical = remaining <= 5 && !isAnswered && !session.timedOutQuestionIds.contains(currentQuestion.id)
                    val isWarning = remaining in 6..10 && !isAnswered && !session.timedOutQuestionIds.contains(currentQuestion.id)

                    val timerColor = when {
                        isCritical -> WrongRed
                        isWarning -> MaterialTheme.colorScheme.secondary
                        else -> MaterialTheme.colorScheme.tertiary
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.surfaceVariant)
                            .padding(horizontal = 16.dp, vertical = 6.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Timer,
                                    contentDescription = "टाइमर",
                                    tint = timerColor,
                                    modifier = Modifier.size(15.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = when {
                                        session.timedOutQuestionIds.contains(currentQuestion.id) && !isAnswered -> "⚠️ समय समाप्त!"
                                        isAnswered -> "✓ उत्तर दर्ज"
                                        else -> "समय शेष: ${remaining}s"
                                    },
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = timerColor
                                )
                            }

                            Text(
                                text = "कुल ${totalSec}s",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                            )
                        }

                        Spacer(modifier = Modifier.height(3.dp))

                        LinearProgressIndicator(
                            progress = { timerFraction },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(3.dp),
                            color = timerColor,
                            trackColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)
                        )
                    }
                }
            }
        },
        bottomBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shadowElevation = 8.dp,
                color = MaterialTheme.colorScheme.surface
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedButton(
                        onClick = { viewModel.previousQuestion() },
                        enabled = currentIndex > 0,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.testTag("quiz_prev_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "पिछला", fontSize = 13.sp)
                    }

                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant
                    ) {
                        Text(
                            text = "${session.userAnswers.size}/${questions.size} उत्तर दिए",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                        )
                    }

                    if (currentIndex < questions.size - 1) {
                        Button(
                            onClick = { viewModel.nextQuestion() },
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                            modifier = Modifier.testTag("quiz_next_button")
                        ) {
                            Text(text = "अगला", fontSize = 13.sp)
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    } else {
                        Button(
                            onClick = { showSubmitDialog = true },
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
                            modifier = Modifier.testTag("quiz_final_submit_button")
                        ) {
                            Text(
                                text = "स्कोर देखें",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSecondary
                            )
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Topic Pill
            item {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                    ) {
                        Text(
                            text = currentQuestion.topic.displayName,
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant
                    ) {
                        Text(
                            text = if (session.mode == QuizMode.PRACTICE) "अभ्यास मोड" else "परीक्षा मोड",
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontSize = 11.sp,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            // Question Statement Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Text(
                            text = "प्रश्न ${currentIndex + 1}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.secondary
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = currentQuestion.questionText,
                            fontSize = 17.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

            val isTimedOut = session.timedOutQuestionIds.contains(currentQuestion.id)

            // Options List
            item {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    currentQuestion.options.forEachIndexed { optionIdx, optionText ->
                        OptionTile(
                            optionIndex = optionIdx,
                            optionText = optionText,
                            isSelected = selectedOptionIndex == optionIdx,
                            isAnswered = isAnswered || isTimedOut,
                            correctIndex = currentQuestion.correctAnswerIndex,
                            mode = session.mode,
                            onSelect = {
                                viewModel.selectOption(currentQuestion.id, optionIdx)
                            }
                        )
                    }
                }
            }

            // In Practice Mode: Immediate Explanation Note Card
            if (session.mode == QuizMode.PRACTICE && (isAnswered || isTimedOut)) {
                item {
                    val isUserCorrect = selectedOptionIndex == currentQuestion.correctAnswerIndex
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (isUserCorrect) CorrectGreenContainer else WrongRedContainer
                        )
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Lightbulb,
                                    contentDescription = null,
                                    tint = if (isUserCorrect) CorrectGreen else WrongRed,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = when {
                                        isUserCorrect -> "सही उत्तर! व्याख्या एवं संदर्भ:"
                                        isTimedOut && !isAnswered -> "समय समाप्त! सही उत्तर व व्याख्या:"
                                        else -> "गलत उत्तर! सही उत्तर व व्याख्या:"
                                    },
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isUserCorrect) CorrectGreen else WrongRed
                                )
                            }
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = currentQuestion.explanation,
                                fontSize = 13.sp,
                                lineHeight = 19.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }

    // Question Palette Bottom Sheet
    if (showPaletteSheet) {
        ModalBottomSheet(
            onDismissRequest = { showPaletteSheet = false },
            sheetState = sheetState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            ) {
                Text(
                    text = "प्रश्नों की सूची (Question Palette)",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "किसी भी प्रश्न पर सीधे जाने के लिए टैप करें",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(14.dp))

                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 48.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.height(260.dp)
                ) {
                    items(questions.size) { idx ->
                        val q = questions[idx]
                        val answered = session.userAnswers.containsKey(q.id)
                        val isCurr = idx == currentIndex
                        val bookmarked = session.bookmarkedIds.contains(q.id)

                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .clip(CircleShape)
                                .background(
                                    when {
                                        isCurr -> MaterialTheme.colorScheme.primary
                                        answered -> MaterialTheme.colorScheme.secondary
                                        else -> MaterialTheme.colorScheme.surfaceVariant
                                    }
                                )
                                .clickable {
                                    scope.launch {
                                        sheetState.hide()
                                        showPaletteSheet = false
                                        viewModel.jumpToQuestion(idx)
                                    }
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "${idx + 1}",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isCurr || answered) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            if (bookmarked) {
                                Box(
                                    modifier = Modifier
                                        .size(6.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFFEAB308))
                                        .align(Alignment.TopEnd)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }

    // Exit Confirmation Dialog
    if (showExitDialog) {
        AlertDialog(
            onDismissRequest = { showExitDialog = false },
            title = { Text(text = "क्विज़ छोड़ें?") },
            text = { Text(text = "यदि आप अभी बाहर निकलते हैं तो वर्तमान प्रगति खो जाएगी। क्या आप वाकई मुख्य पृष्ठ पर जाना चाहते हैं?") },
            confirmButton = {
                TextButton(
                    onClick = {
                        showExitDialog = false
                        viewModel.navigateToHome()
                    }
                ) {
                    Text(text = "बाहर निकलें", color = MaterialTheme.colorScheme.error)
                }
            },
            dismissButton = {
                TextButton(onClick = { showExitDialog = false }) {
                    Text(text = "जारी रखें")
                }
            }
        )
    }

    // Submit Confirmation Dialog
    if (showSubmitDialog) {
        val answeredCount = session.userAnswers.size
        val unAnsweredCount = questions.size - answeredCount

        AlertDialog(
            onDismissRequest = { showSubmitDialog = false },
            title = { Text(text = "क्विज़ सबमिट करें?") },
            text = {
                Column {
                    Text(text = "आपने कुल ${questions.size} में से $answeredCount प्रश्नों के उत्तर दिए हैं।")
                    if (unAnsweredCount > 0) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "$unAnsweredCount प्रश्न अभी शेष हैं। क्या आप अभी अंतिम स्कोर देखना चाहते हैं?",
                            color = MaterialTheme.colorScheme.secondary,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        showSubmitDialog = false
                        viewModel.submitQuiz()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text(text = "हां, स्कोर देखें")
                }
            },
            dismissButton = {
                TextButton(onClick = { showSubmitDialog = false }) {
                    Text(text = "और प्रश्न हल करें")
                }
            }
        )
    }
}

@Composable
private fun OptionTile(
    optionIndex: Int,
    optionText: String,
    isSelected: Boolean,
    isAnswered: Boolean,
    correctIndex: Int,
    mode: QuizMode,
    onSelect: () -> Unit
) {
    val optionLabels = listOf("A", "B", "C", "D")
    val label = optionLabels.getOrElse(optionIndex) { "${optionIndex + 1}" }

    // Color resolution depending on Practice mode vs Exam mode
    val isCorrectOption = optionIndex == correctIndex
    val isUserSelection = isSelected

    val (tileBg, tileBorder, textColor) = when {
        mode == QuizMode.PRACTICE && isAnswered -> {
            when {
                isCorrectOption -> Triple(
                    CorrectGreenContainer,
                    CorrectGreen,
                    Color(0xFF14532D)
                )
                isUserSelection && !isCorrectOption -> Triple(
                    WrongRedContainer,
                    WrongRed,
                    Color(0xFF7F1D1D)
                )
                else -> Triple(
                    MaterialTheme.colorScheme.surface,
                    MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
        }
        isSelected -> Triple(
            MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.7f),
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.onPrimaryContainer
        )
        else -> Triple(
            MaterialTheme.colorScheme.surface,
            MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
            MaterialTheme.colorScheme.onSurface
        )
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = if (isSelected || (mode == QuizMode.PRACTICE && isAnswered && isCorrectOption)) 2.dp else 1.dp,
                color = tileBorder,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable(
                enabled = !(mode == QuizMode.PRACTICE && isAnswered),
                onClick = onSelect
            )
            .testTag("option_tile_$optionIndex"),
        shape = RoundedCornerShape(12.dp),
        color = tileBg
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 13.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = CircleShape,
                color = if (isSelected || (mode == QuizMode.PRACTICE && isAnswered && isCorrectOption)) tileBorder else MaterialTheme.colorScheme.surfaceVariant,
                modifier = Modifier.size(30.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    if (mode == QuizMode.PRACTICE && isAnswered) {
                        if (isCorrectOption) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(16.dp)
                            )
                        } else if (isUserSelection) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(16.dp)
                            )
                        } else {
                            Text(
                                text = label,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    } else {
                        Text(
                            text = label,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = optionText,
                fontSize = 14.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                lineHeight = 20.sp,
                color = textColor,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
