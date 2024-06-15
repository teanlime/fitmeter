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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.teanlime.wellscore.history.ui.HistoryComposable
import com.teanlime.wellscore.navigation.HistoryNavigationDestination
import com.teanlime.wellscore.navigation.TrackNavigationDestination
import com.teanlime.wellscore.track.ui.TrackComposable
import com.teanlime.wellscore.ui.theme.WellScoreTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

      Column(modifier = Modifier.padding(innerPadding)) {
        val showHistory = rememberSaveable { mutableStateOf(false) }

        Button(
          modifier = Modifier.padding(top = 12.dp, bottom = 12.dp),
          onClick = { showHistory.value = !showHistory.value }
        ) {
          Text(text = "Toggle History")
        }

        val navController = rememberNavController()

        NavHost(
          modifier = Modifier.padding(12.dp),
          navController = navController,
          startDestination = TrackNavigationDestination.toString(),
        ) {
          composable(TrackNavigationDestination.toString()) {
            TrackComposable()
          }
          composable(HistoryNavigationDestination.toString()) {
            HistoryComposable()
          }
        }

        if (showHistory.value) {
          navController.navigate(HistoryNavigationDestination.toString())
        } else {
          navController.navigate(TrackNavigationDestination.toString())
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
