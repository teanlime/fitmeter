package com.teanlime.wellscore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    val showHistory = rememberSaveable { mutableStateOf(false) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
      Column(modifier = Modifier.padding(innerPadding).padding(start = 12.dp, end = 12.dp)) {
        TrackComposable()

        Button(
          modifier = Modifier.padding(top = 12.dp, bottom = 12.dp),
          onClick = { showHistory.value = !showHistory.value }
        ) {
          Text(text = "Toggle History")
        }

        if(showHistory.value) {
          HistoryComposable()
        }
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun GMainActivityComposablePreview() {
  MainActivityComposable()
}