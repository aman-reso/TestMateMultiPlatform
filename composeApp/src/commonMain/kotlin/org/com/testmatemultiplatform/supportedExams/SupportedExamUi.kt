package org.com.testmatemultiplatform.supportedExams

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.com.testmatemultiplatform.core.components.AppCheckBox
import org.com.testmatemultiplatform.core.components.BodyLargeTextView
import org.com.testmatemultiplatform.core.components.LabelLargeTextView
import org.com.testmatemultiplatform.core.theme.borderColor

@Composable
fun SupportedExamUi(modifier: Modifier) {
    val expandExamCategory =
        remember { mutableStateMapOf<Long, Boolean>() }
    val subcategoryResponse = remember {
        mutableStateMapOf<Long, Boolean>()
    }

    LazyColumn(
        modifier = modifier
    ) {
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        mockSupportedExamResponses.forEach {
            supportedExamCategoryItem(
                supportedExamResponse = it,
                isExpanded = expandExamCategory[it.id] == true,
                onExpandClick = { id ->
                    expandExamCategory[id] = !(expandExamCategory[id] ?: false)
                },
                subcategoryResponse
            )
            item {
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

private fun LazyListScope.supportedExamCategoryItem(
    supportedExamResponse: SupportedExamResponse,
    isExpanded: Boolean,
    onExpandClick: (Long) -> Unit,
    subcategoryResponse: SnapshotStateMap<Long, Boolean>
) {
    item(key = supportedExamResponse.id) {
        val rotationAngle by animateFloatAsState(
            targetValue = if (isExpanded) 180f else 0f,
            animationSpec = tween(durationMillis = 300)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth().background(
                    color = borderColor,
                    shape = RoundedCornerShape(
                        topEnd = 8.dp,
                        topStart = 8.dp,
                        bottomEnd = if (isExpanded) 0.dp else 8.dp,
                        bottomStart = if (isExpanded) 0.dp else 8.dp
                    )
                ).padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BodyLargeTextView(
                text = supportedExamResponse.examName ?: "",
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.Medium
            )
            if (!supportedExamResponse.subCategory.isNullOrEmpty()) {
                IconButton(onClick = {
                    onExpandClick(supportedExamResponse.id)
                }, modifier = Modifier.rotate(rotationAngle)) {
                    Icon(
                        imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = null
                    )
                }
            }
        }
    }
    if (isExpanded) {
        supportedExamResponse.subCategory?.forEachIndexed { index, subCategory ->
            item {
                val isLastItem = index == supportedExamResponse.subCategory.size - 1

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = borderColor,
                            shape = RoundedCornerShape(
                                bottomStart = if (isLastItem) 8.dp else 0.dp,
                                bottomEnd = if (isLastItem) 8.dp else 0.dp,
                                topStart = 0.dp,
                                topEnd = 0.dp
                            )
                        ).padding(
                            start = 12.dp,
                            end = 12.dp,
                            bottom = if (isLastItem) 8.dp else 4.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    AsyncImage(
                        model = "https://gs-groups-images.grdp.co/2021/8/img1630064357409-61.png",
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(end = 8.dp)
                            .background(color = Color.Transparent, shape = CircleShape)
                    )

                    LabelLargeTextView(
                        subCategory.subCategory ?: "",
                        modifier = Modifier.weight(1f)
                    )

                    AppCheckBox(
                        checked = subcategoryResponse[subCategory.id] ?: false,
                        onCheckedChange = {
                            subcategoryResponse[subCategory.id] = it
                        },
                        modifier = Modifier.size(24.dp).scale(0.7f)
                    )
                }
            }
        }
    }
}
