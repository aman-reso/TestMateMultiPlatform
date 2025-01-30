package org.com.testmatemultiplatform.group.post.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import coil3.request.crossfade
import org.com.testmatemultiplatform.core.components.BodyMediumTextView
import org.com.testmatemultiplatform.core.components.TitleMediumTextView
import org.com.testmatemultiplatform.group.post.model.GroupPostResponse

fun LazyListScope.imageOnlyContentPost(
    modifier: Modifier,
    post: GroupPostResponse,
    onRetry: () -> Unit,
    onMenuAction: (String) -> Unit = {}
) {
    item(post.id) {
        Column(modifier) {
            groupPostCommonHeader(post)
            if (post.title.isNotEmpty()) {
                TitleMediumTextView(post.content)
            }
            ImageContentWithState(
                imageUrl = post.content,
                onRetry = onRetry,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
            )
            if (post.content.isNotBlank()) {
                Spacer(modifier = Modifier.height(12.dp))
                BodyMediumTextView(post.content)
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
private fun ImageContentWithState(
    imageUrl: String,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    var loadState by remember { mutableStateOf<ImageLoadState>(ImageLoadState.Success) }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clickable { if (loadState is ImageLoadState.Error) onRetry() }
    ) {
        when (val state = loadState) {
            is ImageLoadState.Loading -> {
                CircularProgressIndicator()
            }

            is ImageLoadState.Success -> {
                AsyncImage(
                    model = ImageRequest.Builder(LocalPlatformContext.current)
                        .data("https://i0.wp.com/spacenews.com/wp-content/uploads/2024/12/54209298773_f912740933_k.jpg?fit=1024%2C683&quality=89&ssl=1")
                        .crossfade(true)
                        .build(),
                    contentDescription = "contentDescription",
                    modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop,
                    onError = { error ->
                        loadState = ImageLoadState.Error
                    },
                    onLoading = {

                    },
                    onSuccess = {

                    }
                )
            }

            is ImageLoadState.Error -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.errorContainer)
                        .padding(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Error",
                        tint = MaterialTheme.colorScheme.error
                    )
                    Text(
                        text = "Tap to retry",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        }
    }
}

@Composable
fun AsyncImageWithFallback(
    imageUrl: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    colorFilter: ColorFilter? = null
) {
//    AsyncImage(
//        imageUrl,
//        contentDescription,
//        modifier = modifier,
//        contentScale = contentScale,
//        colorFilter = colorFilter
//    )
    AsyncImage(
        model = ImageRequest.Builder(LocalPlatformContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = contentScale,
        onError = { error ->

        },
        onLoading = {

        },
        onSuccess = {

        }
    )
}

sealed class ImageLoadState {
    data object Loading : ImageLoadState()
    data object Success : ImageLoadState()
    data object Error : ImageLoadState()
}