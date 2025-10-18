package com.example.tuan3.ui



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.tuan3.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageDetailScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Images",
                        style = MaterialTheme.typography.titleLarge.copy(
                            color = Color(0xFF1E88E5),
                            fontWeight = FontWeight.Bold

                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color(0xFF1E88E5)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 🖼️ Ảnh từ URL
            Image(
                painter = painterResource(id = R.drawable.dentho),
                contentDescription = "Image from local",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

// Cập nhật Text với liên kết (nếu muốn giữ liên kết)
            Text(
                text = buildAnnotatedString {
                    withLink(
                        LinkAnnotation.Url(
                            url = "https://www.google.com/imgres?q=h%C3%ACnh%20anime&imgurl=https%3A%2F%2Fimages2.thanhnien.vn%2Fzoom%2F1200_630%2FUploaded%2Fduyphuc%2F2022_06_16%2Fanh-2-3761.jpg&imgrefurl=https%3A%2F%2Fthanhnien.vn%2Fviet-nam-tuoi-dep-moi-la-theo-phong-cach-hoat-hinh-nhat-ban-1851469136.htm&docid=EmLdeiOeYZKMFM&tbnid=PISfLLCcWM5K-M&vet=12ahUKEwjXvKDd0ayQAxUy0DQHHa3qDaw4ChAzegQILRAA..i&w=1200&h=630&hcb=2&ved=2ahUKEwjXvKDd0ayQAxUy0DQHHa3qDaw4ChAzegQILRAA" // Liên kết cục bộ giả định, không bắt buộc
                        )
                    ) {
                        append("https://images2.thanhnien.vn/zoom/1200_630/Uploaded/duyphuc/2022_06_16/anh-2-3761.jpg")
                    }
                },
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color(0xFF1E88E5),
                    textDecoration = TextDecoration.Underline
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 🏫 Ảnh trong app
            Image(
                painter = painterResource(id = R.drawable.vutru),
                contentDescription = "Local image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "In app",
                color = Color.Black,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize
            )
        }
    }
}
