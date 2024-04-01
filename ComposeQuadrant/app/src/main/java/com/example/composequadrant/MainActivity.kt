package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                     ComposeQuadrant()
                }
            }
        }
    }
}

//Color(0xFFEADDFF)
//Color(0xFFD0BCFF)
//Color(0xFFB69DF8)
//Color(0xFFF6EDFF)

@Composable
fun ComposeQuadrant(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1F)) {
            InfoCard(
                heading = stringResource(R.string.app_text_heading),
                content = stringResource(R.string.app_text_content),
                hex_color = Color(0xFFEADDFF),
                modifier = Modifier.weight(1F)
            )
            InfoCard(
                heading = stringResource(R.string.app_image_heading),
                content = stringResource(R.string.app_image_content),
                hex_color = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1F)
            )
        }
        Row(Modifier.weight(1F)) {
            InfoCard(
                heading = stringResource(R.string.app_row_heading),
                content = stringResource(R.string.app_row_content),
                hex_color = Color(0xFFB69DF8),
                modifier = Modifier.weight(1F)
            )
            InfoCard(
                heading = stringResource(R.string.app_column_heading),
                content = stringResource(R.string.app_column_content),
                hex_color = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1F)
            )
        }
    }
}

@Composable
fun InfoCard(heading: String, content: String, hex_color: Color, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize().background(hex_color), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = heading, textAlign = TextAlign.Justify, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))
        Text(text = content, textAlign = TextAlign.Justify, modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposeQuadrantPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrant()
    }
}