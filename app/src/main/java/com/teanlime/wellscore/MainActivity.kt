package com.teanlime.wellscore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.teanlime.wellscore.track.ui.TrackComposable
import com.teanlime.wellscore.ui.theme.WellScoreTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MainActivityComposable()
    }
  }
}

@Composable
fun MainActivityComposable() {
  WellScoreTheme {
    Scaffold(
      modifier = Modifier.fillMaxSize(),
      content = { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
          TrackComposable()
        }
    })
  }
}

@Preview(showBackground = true)
@Composable
fun GMainActivityComposablePreview() {
  MainActivityComposable()
}