package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.QuestionReviewItem
import com.example.ui.theme.CorrectGreen
import com.example.ui.theme.CorrectGreenContainer
import com.example.ui.theme.WrongRed
import com.example.ui.theme.WrongRedContainer
import com.example.ui.viewmodel.QuizUiState
import com.example.ui.viewmodel.QuizViewModel

enum class ReviewFilter(val label: String) {
    ALL("सभी प्रश्न"),
    CORRECT("सही (Correct)"),
    INCORRECT("गलत (Incorrect)"),
    SKIPPED("छूटे हुए (Skipped)")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(
    uiState: QuizUiState,
    viewModel: QuizViewModel
) {
    val summary = uiState.session.resultSummary

    BackHandler {
        viewModel.navigateToHome()
    }

    if (summary == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "परिणाम उपलब्ध नहीं है")
        }
        return
    }

    var selectedFilter by remember { mutableStateOf(ReviewFilter.ALL) }

    val filteredReviews = when (selectedFilter) {
        ReviewFilter.ALL -> summary.reviews
        ReviewFilter.CORRECT -> summary.reviews.filter { it.isCorrect }
        ReviewFilter.INCORRECT -> summary.reviews.filter { !it.isCorrect && !it.isSkipped }
        ReviewFilter.SKIPPED -> summary.reviews.filter { it.isSkipped }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "अंतिम स्कोरकार्ड (Final Score)",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateToHome() },
                        modifier = Modifier.testTag("result_home_nav")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "मुख्य पृष्ठ",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = { viewModel.navigateToHome() }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "होम",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Main Score Celebration Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(22.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        MaterialTheme.colorScheme.primary,
                                        Color(0xFF4C0B0B)
                                    )
                                )
                            )
                            .padding(22.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            // Circular Score Badge
                            Surface(
                                shape = CircleShape,
                                color = Color.White.copy(alpha = 0.15f),
                                modifier = Modifier
                                    .size(110.dp)
                                    .border(3.dp, MaterialTheme.colorScheme.secondary, CircleShape)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                        Text(
                                            text = "${summary.correctCount} / ${summary.totalQuestions}",
                                            fontSize = 22.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = Color.White
                                        )
                                        Text(
                                            text = "${String.format("%.1f", summary.scorePercentage)}%",
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.secondary
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(14.dp))

                            Text(
                                text = summary.feedbackTitle,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = summary.feedbackSubtitle,
                                fontSize = 12.sp,
                                color = Color(0xFFF3F4F6),
                                modifier = Modifier.padding(horizontal = 12.dp)
                            )
                        }
                    }
                }
            }

            // Metric Breakdown Grid
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    MetricCard(
                        title = "सही उत्तर",
                        value = "${summary.correctCount}",
                        color = CorrectGreen,
                        containerColor = CorrectGreenContainer,
                        modifier = Modifier.weight(1f)
                    )
                    MetricCard(
                        title = "गलत उत्तर",
                        value = "${summary.wrongCount}",
                        color = WrongRed,
                        containerColor = WrongRedContainer,
                        modifier = Modifier.weight(1f)
                    )
                    MetricCard(
                        title = "छोड़े गए",
                        value = "${summary.skippedCount}",
                        color = Color(0xFF4B5563),
                        containerColor = Color(0xFFF3F4F6),
                        modifier = Modifier.weight(1f)
                    )
                    MetricCard(
                        title = "समय",
                        value = formatTime(summary.timeTakenSeconds),
                        color = MaterialTheme.colorScheme.secondary,
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            // Action Buttons
            item {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    if (summary.wrongCount > 0 || summary.skippedCount > 0) {
                        Button(
                            onClick = { viewModel.retakeIncorrectOnly() },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .testTag("retake_incorrect_button"),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Replay,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "गलत/छूटे प्रश्न पुनः हल करें (${summary.wrongCount + summary.skippedCount} प्रश्न)",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        OutlinedButton(
                            onClick = { viewModel.retakeCurrentQuiz() },
                            modifier = Modifier
                                .weight(1f)
                                .height(46.dp)
                                .testTag("retake_all_button"),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(text = "यही क्विज़ दोबारा", fontSize = 12.sp)
                        }

                        Button(
                            onClick = { viewModel.navigateToHome() },
                            modifier = Modifier
                                .weight(1f)
                                .height(46.dp)
                                .testTag("new_quiz_button"),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.secondary
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "नया क्विज़",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSecondary
                            )
                        }
                    }
                }
            }

            // Detailed Review Section Header
            item {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "विस्तृत प्रश्न समीक्षा (Question Analysis)",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(6.dp))

                // Review Filter Chips
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    ReviewFilter.values().forEach { filter ->
                        val isSelected = selectedFilter == filter
                        val filterCount = when (filter) {
                            ReviewFilter.ALL -> summary.reviews.size
                            ReviewFilter.CORRECT -> summary.correctCount
                            ReviewFilter.INCORRECT -> summary.wrongCount
                            ReviewFilter.SKIPPED -> summary.skippedCount
                        }

                        FilterChip(
                            selected = isSelected,
                            onClick = { selectedFilter = filter },
                            label = {
                                Text(
                                    text = "${filter.label} ($filterCount)",
                                    fontSize = 11.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                )
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MaterialTheme.colorScheme.primary,
                                selectedLabelColor = Color.White
                            )
                        )
                    }
                }
            }

            // Question Reviews
            itemsIndexed(filteredReviews) { index, reviewItem ->
                ReviewQuestionCard(
                    review = reviewItem,
                    displayIndex = index + 1
                )
            }

            item {
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
private fun MetricCard(
    title: String,
    value: String,
    color: Color,
    containerColor: Color,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        color = containerColor
    ) {
        Column(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = value,
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold,
                color = color
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = title,
                fontSize = 10.sp,
                color = color.copy(alpha = 0.9f),
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
private fun ReviewQuestionCard(
    review: QuestionReviewItem,
    displayIndex: Int
) {
    val q = review.question
    val statusColor = when {
        review.isCorrect -> CorrectGreen
        review.isSkipped -> Color(0xFF6B7280)
        else -> WrongRed
    }

    val statusContainer = when {
        review.isCorrect -> CorrectGreenContainer
        review.isSkipped -> Color(0xFFF3F4F6)
        else -> WrongRedContainer
    }

    val statusText = when {
        review.isCorrect -> "✓ सही (Correct)"
        review.isSkipped -> "— अनुत्तरित (Skipped)"
        else -> "✗ गलत (Incorrect)"
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            // Header Row: Topic & Status
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant
                ) {
                    Text(
                        text = q.topic.displayName,
                        fontSize = 10.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                    )
                }

                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = statusContainer
                ) {
                    Text(
                        text = statusText,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = statusColor,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Question Statement
            Text(
                text = "$displayIndex. ${q.questionText}",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Options summary
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                q.options.forEachIndexed { optIdx, optText ->
                    val isCorrectOption = optIdx == q.correctAnswerIndex
                    val isUserChoice = optIdx == review.userSelectedIndex

                    val (rowBg, rowBorder, rowTextColor) = when {
                        isCorrectOption -> Triple(CorrectGreenContainer, CorrectGreen, Color(0xFF14532D))
                        isUserChoice && !isCorrectOption -> Triple(WrongRedContainer, WrongRed, Color(0xFF7F1D1D))
                        else -> Triple(Color.Transparent, Color.Transparent, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f))
                    }

                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = rowBg,
                        border = if (isCorrectOption || isUserChoice) {
                            borderModifier(rowBorder)
                        } else null,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val prefix = when (optIdx) {
                                0 -> "(A)"
                                1 -> "(B)"
                                2 -> "(C)"
                                else -> "(D)"
                            }
                            Text(
                                text = "$prefix $optText",
                                fontSize = 12.sp,
                                fontWeight = if (isCorrectOption || isUserChoice) FontWeight.Bold else FontWeight.Normal,
                                color = rowTextColor,
                                modifier = Modifier.weight(1f)
                            )
                            if (isCorrectOption) {
                                Text(
                                    text = "सही उत्तर",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = CorrectGreen
                                )
                            } else if (isUserChoice) {
                                Text(
                                    text = "आपका उत्तर",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = WrongRed
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // PDF Explanation Reference Box
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(10.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Icon(
                        imageVector = Icons.Default.Lightbulb,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier
                            .size(16.dp)
                            .padding(top = 2.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Column {
                        Text(
                            text = "नोट्स तथ्य व संदर्भ:",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.secondary
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = q.explanation,
                            fontSize = 12.sp,
                            lineHeight = 17.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

private fun borderModifier(color: Color): androidx.compose.foundation.BorderStroke {
    return androidx.compose.foundation.BorderStroke(1.dp, color)
}

private fun formatTime(seconds: Long): String {
    val mins = seconds / 60
    val secs = seconds % 60
    return if (mins > 0) "${mins}m ${secs}s" else "${secs}s"
}
