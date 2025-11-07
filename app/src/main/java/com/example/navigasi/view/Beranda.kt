package com.example.navigasi.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigasi.R
import com.example.navigasi.ui.theme.NavigasiTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BerandaScreen(onSubmitButtonClicked: () -> Unit) {
    val darkColor = Color.Black
    val lightColor = Color(0xFFF5F5F5)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Beranda", color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = darkColor)
            )
        },
        containerColor = lightColor
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Selamat Datang", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Spacer(modifier = Modifier.height(48.dp))
            Image(
                painter = painterResource(id = R.drawable.download),
                contentDescription = "Logo",
                modifier = Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.height(48.dp))
            Text("Hafizh Harimurti", fontSize = 22.sp, color = Color.Black)
            Text("20230140216", fontSize = 18.sp, color = Color.Gray)
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = onSubmitButtonClicked,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = darkColor)
            ) {
                Text(stringResource(R.string.submit), modifier = Modifier.padding(8.dp), color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BerandaPreview() {
    NavigasiTheme {
        BerandaScreen({})
    }
}
