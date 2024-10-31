package com.example.datingapp.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.datingapp.R
import com.example.datingapp.ui.theme.DatingAppTheme
import com.example.datingapp.ui.theme.Purple40
import kotlin.math.absoluteValue

@Preview
@Composable
fun SearchScreen(navController: NavController = rememberNavController()) {
    DatingAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White,
        ) {
            Column {

                TopBar()
                Spacer(modifier = Modifier.weight(1f))
                val ims = listOf(
                    R.drawable.g4,
                    R.drawable.g5,
                    R.drawable.g6,
                    R.drawable.g7,
                    R.drawable.g4,
                    R.drawable.g5,
                    R.drawable.g6,
                    R.drawable.g7,
                    R.drawable.g4,
                    R.drawable.g5
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        contentScale = ContentScale.FillWidth,
                        painter = painterResource(R.drawable.wordmap),
                        contentDescription = "", modifier = Modifier
                            .alpha(0.1f)
                            .fillMaxWidth()
                    )
                    ImageSlider(ims)

                }
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .height(80.dp)
                        .clip(RoundedCornerShape(50))
                        .background(color = Purple40)
                        .fillMaxWidth(), contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Start\nfree",
                        color = Color.White,
                        textAlign = TextAlign.Center, fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.weight(0.5f))

            }
        }
    }
}

@Composable
fun TopBar() {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 10.dp)) {
        Row(
            modifier = Modifier
                .wrapContentWidth()
                .padding(horizontal = 10.dp)
                .border(1.dp, color = Color.Gray, shape = RoundedCornerShape(20.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.size(10.dp))
            Image(
                painter = painterResource(R.drawable.coin),
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = "00",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                modifier = Modifier
                    .padding(8.dp)
            )
            Icon(
                imageVector = Icons.Default.AddCircle,
                contentDescription = null,
                tint = Purple40,
                modifier = Modifier.padding(end = 10.dp)
            )

        }
        Spacer(modifier = Modifier.weight(1f))
        Row {
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = null,
                tint = Purple40,
                modifier = Modifier.padding(end = 10.dp)
            )
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_time),
                contentDescription = null,
                tint = Purple40,
                modifier = Modifier.padding(end = 10.dp)
            )
        }
    }


}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSlider(images: List<Int>) {
    val totalImages = images.size
    val initialPage = if (totalImages > 0) totalImages / 2 else 0 // Start from the center

    val pagerState = rememberPagerState(initialPage = initialPage, pageCount = { images.size })

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp), // Adjust the height to fit the images
        contentAlignment = Alignment.Center
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp), // Adjust the height to fit the images
            contentPadding = PaddingValues(horizontal = 0.dp),
            pageSize = PageSize.Fixed(80.dp) // Adjust page size to show multiple images with overlap
        ) { page ->
            // Calculate the index for the current image to display, considering wrap-around
            val imageIndex = (page + totalImages) % totalImages

            // Calculate scale based on the current page index relative to the current page
            val currentPage = pagerState.currentPage
            val distanceFromCenter = (page - currentPage).absoluteValue
            val scale = when {
                distanceFromCenter == 2 -> 1.2f // Center image
                distanceFromCenter == 1 -> 0.9f // Adjacent images
                else -> 0.8f // Other images
            }

            Box(
                modifier = Modifier
                    .width(100.dp) // Adjust width to fit more images with overlap
                    .height(100.dp) // Adjust height accordingly
                    .clip(CircleShape) // Clip the box to a circle
                    .background(Color.Transparent) // Optional background color
                    .scale(scale)
                    .padding(0.dp) // No padding to ensure overlap
            ) {
                Image(
                    painter = painterResource(id = images[imageIndex]),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize() // Fill the box with the image
                        .clip(CircleShape), // Ensure the image is also clipped to a circle
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}
