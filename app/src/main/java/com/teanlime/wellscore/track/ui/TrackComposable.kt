package com.teanlime.wellscore.track.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.teanlime.wellscore.track.ui.TrackComposable.WEIGHT_TEXT_FIELD_TAG

@Composable
fun TrackComposable(modifier: Modifier = Modifier) {
  var weight by remember { mutableStateOf("") }

  Column {
    Text(text = "Weight")
    TextField(value = weight,
      modifier = Modifier.testTag(WEIGHT_TEXT_FIELD_TAG),
      onValueChange = {
        weight = it
      })
    Button(
      onClick = { weight = "" }) {
      Text(text = "Submit")
    }
  }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun TrackComposablePreview() {
  TrackComposable()
}

object TrackComposable {
  val WEIGHT_TEXT_FIELD_TAG = "WEIGHT_TEXT_FIELD_TAG"
}