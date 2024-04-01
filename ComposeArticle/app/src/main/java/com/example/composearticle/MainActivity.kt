package com.example.composearticle

import android.media.Image
import android.os.Bundle
import android.widget.GridLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposableArticle()
                }
            }
        }
    }
}

@Composable
fun ImageBanner(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Image(painter = image, contentDescription = null)
}
@Composable
fun ComposableArticle(modifier: Modifier = Modifier) {
    Column(modifier) {
        ImageBanner(modifier)
        Text(
            text = stringResource(R.string.jetpack_compose_heading),
            fontSize = 24.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = stringResource(R.string.jetpack_compose_paragraph_1),
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start=16.dp, end=16.dp)
        )

        Text(
            text = stringResource(R.string.jetpack_compose_paragraph_2),
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start=16.dp, end=16.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposeArticlePreview() {
    ComposeArticleTheme {
        ComposableArticle()
    }
}