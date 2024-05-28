package com.teanlime.wellscore.history.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.teanlime.wellscore.model.track.TrackedRepository

@Composable
fun HistoryComposable(modifier: Modifier = Modifier) {
  val trackedHistory = remember {
    TrackedRepository.tracks
  }

  LazyColumn {
    item {
      trackedHistory.forEach {
        Text(text = it.value.toString())
      }
    }
  }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun HistoryComposablePreview() {
  HistoryComposable()
}

object HistoryComposable {
}