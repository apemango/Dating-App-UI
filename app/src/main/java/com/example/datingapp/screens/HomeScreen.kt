package com.example.datingapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.datingapp.R
import com.example.datingapp.ui.theme.DatingAppTheme

data class User(
    val name: String,
    val country: String,
    val online: Boolean,
    val imageRes: Int // Resource ID for profile image
)

@Preview
@Composable
fun HomeScreen(navController: NavController = rememberNavController()) {
    DatingAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            val users = remember {
                listOf(
                    User("kiaraa", "India", true, R.drawable.g4),
                    User("Haya", "India", true, R.drawable.g5),
                    User("other user", "India", false, R.drawable.g6),
                    User("other user", "India", false, R.drawable.g7),
                    User("kiaraa", "India", true, R.drawable.g4),
                    User("kiaraa", "India", true, R.drawable.g4),
                    User("Haya", "India", true, R.drawable.g5),
                    User("other user", "India", false, R.drawable.g6),
                    User("other user", "India", false, R.drawable.g7),
                    User("kiaraa", "India", true, R.drawable.g4),
                    User("Haya", "India", true, R.drawable.g5),
                    User("other user", "India", false, R.drawable.g6),
                    User("other user", "India", false, R.drawable.g7),
                    User("other user", "India", false, R.drawable.g6),
                    User("other user", "India", false, R.drawable.g7),
                    User("kiaraa", "India", true, R.drawable.g4),
                    User("Haya", "India", true, R.drawable.g5),
                    User("other user", "India", false, R.drawable.g6),
                    User("other user", "India", false, R.drawable.g7),
                    User("kiaraa", "India", true, R.drawable.g4),
                    User("Haya", "India", true, R.drawable.g5),
                    User("other user", "India", false, R.drawable.g6),
                    User("other user", "India", false, R.drawable.g7),
                    User("other user", "India", false, R.drawable.g6),
                    User("other user", "India", false, R.drawable.g7),
                    User("kiaraa", "India", true, R.drawable.g4),
                )
            }
            var selectedTab by remember { mutableStateOf("People") }

            Column() {

                TopAppBarWithTabs(
                    selectedTab = selectedTab,
                    onTabSelected = { selectedTab = it },
                    onIconClick = { /* Handle options icon click */ }
                )

                UserList(users)
            }

        }
    }
}

@Composable
fun UserList(users: List<User>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.background(color = Color.White).fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(users) { user ->
            UserCard(user = user)
        }
    }
}


@Composable
fun UserCard(user: User) {
    Column(
        modifier = Modifier
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .size(240.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.LightGray)
        ) {
            Image(
                painter = painterResource(id = user.imageRes),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Gray)
            )

            Row(
                modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.Bottom
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    UserProfileInfo(user, modifier = Modifier.padding(horizontal = 10.dp))

                }
                RoundedImageWithIcon(
                    imageRes = R.drawable.one, // Replace with your image resource
                    iconRes = Icons.Default.PlayArrow, // Replace with your icon resource
                    iconBackgroundColor = Color.Magenta,
                    modifier = Modifier.padding(5.dp)
                )
            }

        }
    }
}

@Composable
private fun UserProfileInfo(user: User, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        // Online Indicator
        Box(
            modifier = Modifier
                .size(15.dp)
                .padding(3.dp)
                .background(color = Color.Green, shape = CircleShape)
        )

        // Username Text
        Text(
            text = user.name,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.tertiaryContainer
        )
    }


    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        // Flag Icon
        Image(
            painter = painterResource(R.drawable.one),
            contentDescription = "",
            modifier = Modifier.size(15.dp)
        )

        // Country Text
        Text(
            maxLines = 1,
            text = user.country,
            fontSize = 14.sp,
            color = Color.White
        )
    }
}


@Composable
fun UserInfo(
    user: User,
    flagIcon: ImageVector,   // Flag icon, assuming it's a vector resource
    onlineIndicatorColor: Color = Color.Green // Customizable online indicator color
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        // Row for the flag and country name
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            // Flag Icon
            Icon(
                imageVector = flagIcon,
                contentDescription = "Country Flag",
                modifier = Modifier.size(18.dp),
                tint = Color.Unspecified // Keep the original color of the flag icon
            )

            // Country Text
            Text(
                text = user.country,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }

        // Row for the indicator and username
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            // Online Indicator
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .background(onlineIndicatorColor, shape = CircleShape)
            )

            // Username Text
            Text(
                text = user.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}


@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "People",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "Party",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )
    }
}


@Composable
fun RoundedImageWithIcon(
    imageRes: Int,
    iconRes: ImageVector,
    iconBackgroundColor: Color = MaterialTheme.colorScheme.primary, modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = modifier
            .size(35.dp) // Adjust size as needed
            .clip(CircleShape)
            .background(Color.White)
            .padding(6.dp) // Inner padding around the image
    ) {
        Icon(
            imageVector = iconRes,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .fillMaxSize()
                .background(iconBackgroundColor, shape = CircleShape)
                .padding(4.dp) // Inner padding for the icon
        )
    }
}

@Composable
fun TopAppBarWithTabs(
    modifier: Modifier = Modifier,
    selectedTab: String = "People",
    onTabSelected: (String) -> Unit = {},
    titleIcon: ImageVector = Icons.Default.MoreVert,
    onIconClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth().background(color = Color.White)
            .padding(vertical = 4.dp, horizontal = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Tabs on the left side
        Row(verticalAlignment = Alignment.CenterVertically) {
            TabItem(
                title = "People",
                isSelected = selectedTab == "People",
                onClick = { onTabSelected("People") }
            )
            TabItem(
                title = "Party",
                isSelected = selectedTab == "Party",
                onClick = { onTabSelected("Party") }
            )
        }

        Image(
            painter = painterResource(R.drawable.icon), contentDescription = "",
            modifier = Modifier
                .size(24.dp), contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun TabItem(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Text(
        text = title,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = if (isSelected) Color.Black else Color.Gray,
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = onClick)
    )
}