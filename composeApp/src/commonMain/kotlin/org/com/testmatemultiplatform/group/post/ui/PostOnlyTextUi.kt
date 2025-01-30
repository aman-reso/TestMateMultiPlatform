package org.com.testmatemultiplatform.group.post.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.com.testmatemultiplatform.core.components.HeadlineSmallTextView
import org.com.testmatemultiplatform.core.components.TitleMediumTextView
import org.com.testmatemultiplatform.group.post.model.GroupPostResponse

fun LazyListScope.textOnlyMessageContent(modifier: Modifier, groupPostResponse: GroupPostResponse) {
    item(key = groupPostResponse.id) {
        TextOnlyPostUi(modifier, groupPostResponse) {

        }
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
fun TextOnlyPostUi(
    modifier: Modifier,
    postResponse: GroupPostResponse,
    onMenuAction: (String) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        groupPostCommonHeader(postResponse)
        Spacer(modifier = Modifier.height(12.dp))
        TitleMediumTextView(postResponse.title)
    }
}