package org.com.testmatemultiplatform.group.create

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.com.testmatemultiplatform.core.components.AppPrimaryButton
import org.com.testmatemultiplatform.core.components.AppSwitch
import org.com.testmatemultiplatform.core.components.AppRadioBtn
import org.com.testmatemultiplatform.core.components.BodySmallTextView
import org.com.testmatemultiplatform.core.components.GeneralizedBasicTextField
import org.com.testmatemultiplatform.core.components.TitleMediumTextView
import org.com.testmatemultiplatform.core.theme.borderColor
import org.com.testmatemultiplatform.core.theme.textSubTitleColor
import org.com.testmatemultiplatform.core.theme.whiteColor

@Composable
fun CreateGroupUi() {
    var groupName by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight().background(whiteColor).padding(16.dp)
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        CircularImageWithEditIcon {

        }
        Spacer(modifier = Modifier.height(16.dp))
        GeneralizedBasicTextField(groupName, onValueChange = {
            groupName = it
        }, placeholder = "Group Name")
        Spacer(modifier = Modifier.height(16.dp))
        GeneralizedBasicTextField(groupName, onValueChange = {
            groupName = it
        }, placeholder = "Group Description(max 100 words)")
        Spacer(modifier = Modifier.height(16.dp))
        CreateGroupOptions {

        }

        AppPrimaryButton(
            onClick = {

            }, text = "Create Group", modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun CircularImageWithEditIcon(
    onEditClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().height(110.dp)
    ) {
        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier.size(100.dp)
        ) {
            Image(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            )

            IconButton(
                onClick = { onEditClick() },
                modifier = Modifier
                    .size(30.dp)
                    .background(Color.White, CircleShape)
                    .border(1.dp, Color.Gray, CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit",
                    tint = Color.Gray,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
private fun ColumnScope.CreateGroupOptions(
    onCreateCircleClick: () -> Unit
) {
    this.apply {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Lock,
                contentDescription = null,
                modifier = Modifier.size(32.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(borderColor).padding(8.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier.fillMaxWidth().weight(1f)
            ) {
                TitleMediumTextView(text = "Public")
                BodySmallTextView(
                    "Anyone can join this group but admin approval required",
                    color = textSubTitleColor
                )
            }
            AppRadioBtn(selected = false, onClick = {})
        }


        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Lock,
                contentDescription = null,
                modifier = Modifier.size(32.dp).clip(RoundedCornerShape(8.dp))
                    .background(borderColor).padding(8.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                TitleMediumTextView(text = "Private")
                BodySmallTextView("Anyone can join this group but admin approval required")
            }
            AppRadioBtn(selected = true, onClick = {})
        }


        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(0.8f)) {
                TitleMediumTextView("Want to share your location?")
                BodySmallTextView(
                    "This will help us to recommend other people so that they can join easily"
                )
            }
            AppSwitch(checked = true, onCheckedChange = {

            })
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

