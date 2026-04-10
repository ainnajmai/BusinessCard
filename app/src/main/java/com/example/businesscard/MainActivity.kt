package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.graphics.Color
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.size
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.Icon

val SoftSage = Color(0xFFCCD5AE)
val EarthyBrown = Color(0xFF606C38)
val DustyGrey = Color(0xFFD4A373)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = SoftSage
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                    ) {

                        BusinessCardHeader(
                            name = "Lt M Ts Nur Ain Najma",
                            title = "Fullstack Developer Noobie"
                        )
                        Spacer(modifier = Modifier.height(50.dp))

                        ContactInfo(
                            phone = "+6010 655 3270",
                            social = "@ainnajmai",
                            email = "ainnajma04@gmail.com"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BusinessCardHeader(name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        // Image Composition
        val image = painterResource(R.drawable.businesscard)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.size(120.dp).padding(bottom = 12.dp)
        )
        // Text Composition: Name and Title
        Text(
            text = name,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = EarthyBrown
        )
        Text(
            text = title,
            color = DustyGrey,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp
        )
    }
}
@Composable
fun ContactInfo(phone: String, social: String, email: String) {
    Column(
        modifier = Modifier.padding(top = 24.dp),
        horizontalAlignment = Alignment.Start
    ) {
        ContactRow(iconResId = R.drawable.call, text = phone)
        ContactRow(iconResId = R.drawable.outline_account_circle_24, text = social)
        ContactRow(iconResId = R.drawable.baseline_chat_bubble_outline_24, text = email)
    }
}

@Composable
fun ContactRow(iconResId: Int, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = null,
            tint = DustyGrey,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            color = EarthyBrown,
            fontSize = 14.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = SoftSage
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                BusinessCardHeader(
                    name = "Lt M Ts Nur Ain Najma",
                    title = "Fullstack Developer Noobie"
                )
                ContactInfo(
                    phone = "+6010 655 3270",
                    social = "@ainnajmai",
                    email = "ainnajma04@gmail.com"
                )
            }
        }
    }
}