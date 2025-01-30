package org.com.testmatemultiplatform.group.post.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.com.testmatemultiplatform.core.components.AppPrimaryButton
import org.com.testmatemultiplatform.core.components.HeadlineLargeTextView
import org.com.testmatemultiplatform.core.theme.whiteBgColor
import org.com.testmatemultiplatform.core.theme.whiteColor
import org.com.testmatemultiplatform.group.post.model.getPost
import org.com.testmatemultiplatform.localstorage.DatabaseHelper
import org.com.testmatemultiplatform.localstorage.Post
import org.com.testmatemultiplatform.localstorage.PostRepository
import org.com.testmatemultiplatform.localstorage.PostViewModel
import org.koin.core.annotation.KoinExperimentalAPI

private val modifier1 = Modifier.background(
    color = whiteColor,
    shape = RoundedCornerShape(8.dp)
).padding(horizontal = 12.dp, vertical = 8.dp)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GroupPostHistoryMainUi(modifier: Modifier, databaseHelper: DatabaseHelper?) {
    if (databaseHelper == null) {
        return
    }
    val postViewModel = remember {
        PostViewModel(PostRepository(databaseHelper.database))
    }
    val postData by postViewModel.posts.collectAsState()
    LaunchedEffect(Unit) {
        
    }

    val post = getPost()

    LazyColumn(modifier) {
        stickyHeader {
            Row(
                modifier = Modifier.fillMaxWidth().background(color = whiteBgColor),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HeadlineLargeTextView(
                    "Group Ramanyan", modifier = Modifier.fillMaxWidth().weight(1f)
                )
                AppPrimaryButton("Create Post", onClick = {

                }, modifier = Modifier.height(36.dp), cornerRadius = 12)
            }
        }

        postData.forEachIndexed { index, it ->
            try {
                val data = post[index].apply {
                    title = it.title
                    content = it.content
                }
                when (data.type) {
                    "TEXT" -> {
                        textOnlyMessageContent(modifier = modifier1, data)
                    }

                    "POLL" -> {
                        pollMessageContent(modifier = modifier1, data)
                    }

                    "IMAGE" -> {
                        imageOnlyContentPost(modifier = modifier1, data, onRetry = {

                        }) {

                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}