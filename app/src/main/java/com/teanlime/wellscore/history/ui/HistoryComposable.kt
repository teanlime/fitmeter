package com.teanlime.wellscore.history.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlin.random.Random

@Composable
fun HistoryComposable(modifier: Modifier = Modifier) {
  val viewModel: HistoryViewModel = viewModel()
  val historyListItems = viewModel.historyState

  Column(modifier = modifier) {

    LazyColumn {
      items(items = historyListItems, key = { it.id }) {
        HistoryItem(it, viewModel.onHistoryItemClicked)
      }
    }
  }
}

@Composable
private fun HistoryItem(state: HistoryUiState, onClick: (String) -> Unit) {
  Row(
    modifier = Modifier
      .background(color = randomColor)
      .clickable(enabled = true, onClick = { onClick(state.id) }),
  ) {
    Text(text = state.label, modifier = Modifier.padding(end = 10.dp))
    Text(text = state.id, modifier = Modifier.weight(1f))
    Text(text = state.value)
  }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun HistoryComposablePreview() {
  HistoryComposable()
}

private val randomColor: Color
  get() = Color(
    red = Random.nextInt(255),
    green = Random.nextInt(255),
    blue = Random.nextInt(255),
    alpha = 255
  )
