package com.example.datingapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.datingapp.R
import com.example.datingapp.Screens
import com.example.datingapp.ui.theme.DatingAppTheme
import com.example.datingapp.ui.theme.Purple40

// Data class to hold user information
data class UserModel(
    val profileImage: Int, // Drawable resource ID
    val username: String,
    val lastMessage: String,
    val lastActiveTime: String
)

@Composable
fun ChatScreen(navController: NavController) {


    DatingAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                val users = listOf(
                    UserModel(R.drawable.one, "John Doe", "Hey, are you free tomorrow?", "2:45 PM"),
                    UserModel(R.drawable.g4, "Jane Smith", "I’ll call you later.", "1:30 PM"),
                    UserModel(R.drawable.g6, "Michael", "Got it, thanks!", "Yesterday"),
                    UserModel(R.drawable.g7, "Sarah Connor", "Let’s meet next week.", "Monday"),
                )

                ChatTopAppBarWithTabs()

                LazyColumn {
                    items(users.size) { index ->
                        ChatUserItem(user = users[index]) {
                            navController.navigate(Screens.ChatConversation.route)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ChatUserItem(user: UserModel, click: () -> Unit) {
    Row(
        modifier = Modifier
            .clickable { click.invoke() }
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile photo
        Image(
            painter = painterResource(user.profileImage),
            contentDescription = "Profile picture of ${user.username}",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(48.dp)
                .aspectRatio(1f)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        ) {
            // Username
            Text(
                text = user.username,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black
            )

            // Last message
            Text(
                text = user.lastMessage,
                fontSize = 14.sp,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        // Last active time
        Text(
            text = user.lastActiveTime,
            fontSize = 12.sp,
            color = Purple40
        )
    }
}


@Composable
fun ChatTopAppBarWithTabs(
    modifier: Modifier = Modifier,
    selectedTab: String = "Message",
    onTabSelected: (String) -> Unit = {},
    titleIcon: ImageVector = Icons.Default.MoreVert,
    onIconClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(vertical = 4.dp, horizontal = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Tabs on the left side
        Row(verticalAlignment = Alignment.CenterVertically) {
            TabItem(
                title = "Message",
                isSelected = selectedTab == "Message",
                onClick = { onTabSelected("Message") }
            )
            TabItem(
                title = "Call",
                isSelected = selectedTab == "Call",
                onClick = { onTabSelected("Call") }
            )
        }

        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(R.drawable.multiple_contact), contentDescription = "",
            modifier = Modifier
                .padding(end = 10.dp)
                .size(18.dp), contentScale = ContentScale.FillBounds
        )
        Image(
            painter = painterResource(R.drawable.three_dots_menu), contentDescription = "",
            modifier = Modifier
                .padding(end = 10.dp)
                .size(18.dp), contentScale = ContentScale.FillBounds
        )
    }
}

