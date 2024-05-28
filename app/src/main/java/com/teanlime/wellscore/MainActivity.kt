package com.teanlime.wellscore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.teanlime.wellscore.history.ui.HistoryComposable
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
    val showHistory = remember { mutableStateOf(false) }

    Scaffold(
      modifier = Modifier.fillMaxSize(),
      content = { innerPadding ->
        Column {
          Box(modifier = Modifier.padding(innerPadding)) {
            if(showHistory.value) {
              HistoryComposable()
            } else {
              TrackComposable()
            }
          }
          Button(
            onClick = { showHistory.value = !showHistory.value }
          ) {
            Text(text = "Toggle History")
          }
        }
    })
  }
}

@Preview(showBackground = true)
@Composable
fun GMainActivityComposablePreview() {
  MainActivityComposable()
}