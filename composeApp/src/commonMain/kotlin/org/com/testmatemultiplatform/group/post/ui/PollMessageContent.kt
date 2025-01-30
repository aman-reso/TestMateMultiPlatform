package org.com.testmatemultiplatform.group.post.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.com.testmatemultiplatform.core.components.HeadlineLargeTextView
import org.com.testmatemultiplatform.core.components.HeadlineSmallTextView
import org.com.testmatemultiplatform.core.components.TitleLargeTextView
import org.com.testmatemultiplatform.core.components.TitleMediumTextView
import org.com.testmatemultiplatform.core.theme.blue10
import org.com.testmatemultiplatform.core.theme.whiteColor
import org.com.testmatemultiplatform.group.post.model.GroupPostResponse
import org.com.testmatemultiplatform.group.post.model.Metadata
import kotlin.math.roundToInt

fun LazyListScope.pollMessageContent(modifier: Modifier, groupPostResponse: GroupPostResponse) {
    item(key = groupPostResponse.id) {
        PollCardUi(modifier, groupPostResponse)
        Spacer(modifier = Modifier.height(12.dp))
    }
}


@Composable
fun PollCardUi(
    modifier: Modifier,
    postResponse: GroupPostResponse,
    onVoteSubmitted: (Int) -> Unit = {}
) {
    var selectedOption by remember { mutableStateOf<Int?>(null) }
    val isVoted by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
    ) {
        groupPostCommonHeader(postResponse)
        TitleMediumTextView(postResponse.title)

        if (isVoted) {
            PollResults(postResponse.metadata)
        } else {
            postResponse.metadata.forEachIndexed { index, option ->
                PollOptionItem(
                    text = option.optionText,
                    isSelected = selectedOption == index,
                    onSelect = { selectedOption = index }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun PollOptionItem(
    text: String,
    isSelected: Boolean,
    onSelect: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .selectable(
                selected = isSelected,
                onClick = onSelect
            ),
        shape = MaterialTheme.shapes.small,
        color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else Color.Transparent,
        border = if (isSelected) null else CardDefaults.outlinedCardBorder()
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
        )
    }
}

@Composable
private fun PollResults(options: List<Metadata>) {
    val totalVotes = options.sumOf { it.attemptedBy }.toFloat()

    Column {
        options.forEach { option ->
            val percentage = if (totalVotes > 0) (option.attemptedBy / totalVotes * 100) else 0f

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = option.optionText,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.weight(1f)
                    )

                    Text(
                        text = "${percentage.roundToInt()}%",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                LinearProgressIndicator(
                    progress = { percentage / 100f },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp),
                    color = MaterialTheme.colorScheme.primary,
                    trackColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
                    strokeCap = StrokeCap.Round,
                    gapSize = 0.dp,
                    drawStopIndicator = {

                    }
                )

                Text(
                    text = "${option.attemptedBy} votes",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}