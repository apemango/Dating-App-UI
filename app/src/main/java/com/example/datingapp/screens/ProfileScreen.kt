package com.example.datingapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.datingapp.R
import com.example.datingapp.ui.theme.DatingAppTheme

@Composable
fun ProfileScreen(navController: NavController) {
    DatingAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(15.dp),
            )  {
                ProfileHeader()
                Spacer(modifier = Modifier.height(20.dp))
                WalletSection()
                Spacer(modifier = Modifier.height(20.dp))
                MenuList()
            }
        }
    }
}

@Composable
fun ProfileHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Logo or Profile Image
        Image(
            painter = painterResource(R.drawable.g7),
            contentDescription = "Profile Logo",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.Gray)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = "Username",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Age", fontSize = 16.sp,color = Color.Black)
                Spacer(modifier = Modifier.width(8.dp))

                // Country flag icon
                Image(
                    painter = painterResource(R.drawable.images),
                    contentDescription = "Country Flag",
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Country Name", fontSize = 16.sp,color = Color.Black)

                Spacer(modifier = Modifier.width(8.dp))

                // Verify icon
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Verified",
                    tint = Color.Blue,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Composable
fun WalletSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color(0xFFF5F5F5), RoundedCornerShape(10.dp))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Coin Icon and Balance
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(R.drawable.coin),
                contentDescription = "Coins",
                tint = Color(0xFFFFD700),
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "100 Coins", fontSize = 18.sp, fontWeight = FontWeight.Bold,color = Color.Black)
        }

        // Get Free Coins Button
        Button(
            onClick = { /* Handle click */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007AFF)),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(text = "Get Free Coins", color = Color.White)
        }
    }
}

@Composable
fun MenuList() {
    val menuItems = listOf(
        "Daily Bonus" to Icons.Default.Star,
        "Credits" to Icons.Default.Info,
        "Package" to Icons.Default.ShoppingCart,
        "My Level" to Icons.Default.ArrowDropDown,
        "Invite to get bonus" to Icons.Default.AccountCircle,
        "App Setting" to Icons.Default.Settings
    )

    Column {
        menuItems.forEach { (title, icon) ->
            MenuItem(title, icon)
            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}

@Composable
fun MenuItem(title: String, icon: ImageVector) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable { /* Handle click */ },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = icon, contentDescription = title, tint = Color.Gray)
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = title, fontSize = 16.sp, color = Color.Black)
        }

        Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Go", tint = Color.Gray)
    }
}
