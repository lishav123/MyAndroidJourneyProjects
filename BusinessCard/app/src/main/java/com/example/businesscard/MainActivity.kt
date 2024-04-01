package com.example.businesscard

import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFd2ffd2))
                .padding(bottom = 100.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )

        {
            ImageCard(name = "Kento Nanami", role = "Android Sorcerer")
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        )

        {
            ContactsFooter(email = "kento.nanami@jujutsu.kaisen", shareTo = "@AndroidSorcerer", contact = "+11 (123) 444 555 666", modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
fun ImageCard(name: String, role: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(R.drawable.android_logo), contentDescription = null, Modifier.size(200.dp).background(Color.Black))
        Text(text = name, fontSize = 40.sp)
        Text(text = role, color = Color(0xFF005500), fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ContactsFooter(email: String, shareTo: String, contact: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.padding(bottom = 5.dp)) {
            Icon(Icons.Rounded.Phone, contentDescription = null, modifier = Modifier.padding(end = 25.dp), tint = Color(0xFF003300))
            Text(text = contact, modifier = Modifier.padding(end = 10.dp))
        }

        Row(modifier = Modifier.padding(bottom = 5.dp)) {
            Icon(Icons.Rounded.Share, contentDescription = null, modifier = Modifier.padding(end = 25.dp), tint = Color(0xFF003300))
            Text(text = shareTo, modifier = Modifier.padding(end = 10.dp))
        }

        Row(modifier = Modifier.padding(bottom = 35.dp)) {
            Icon(Icons.Rounded.Email, contentDescription = null, modifier = Modifier.padding(end = 25.dp), tint = Color(0xFF003300))
            Text(text = email, modifier = Modifier.padding(end = 10.dp))
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}