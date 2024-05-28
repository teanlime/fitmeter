package com.teanlime.wellscore.track.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.teanlime.wellscore.model.track.MetricSystemDefinitions.MetricSystemDefinition
import com.teanlime.wellscore.model.track.StandardMetricTypes.WEIGHT
import com.teanlime.wellscore.model.track.Tracked
import com.teanlime.wellscore.model.track.TrackedRepository
import com.teanlime.wellscore.track.ui.TrackComposable.WEIGHT_INPUT
import java.math.BigDecimal

@Composable
fun TrackComposable(modifier: Modifier = Modifier) {
  val weightMetric = remember { mutableStateOf(
      Tracked(
        metric = MetricSystemDefinition.definitions[WEIGHT]!!,
        lowerBound = BigDecimal.valueOf(0.0),
        upperBound = BigDecimal.valueOf(400.0),
        value = BigDecimal.valueOf(70.0)
    ))
  }
  val weightValue by remember {
    derivedStateOf {
      weightMetric.value.normalizedValue
    }
  }

  Column {
    Text(text = "Weight")
    Row {
      Button(
        onClick = { weightMetric.value = weightMetric.value.decrement() }) {
        Text(text = "-")
      }
      TextField(
        value = weightValue.toString(),
        modifier = Modifier.testTag(WEIGHT_INPUT),
        onValueChange = { newValue: String ->
          weightMetric.value = weightMetric.value.setTo(BigDecimal.valueOf(newValue.toDouble()))
        },
      )
      Button(
        onClick = { weightMetric.value = weightMetric.value.increment() }) {
        Text(text = "+")
      }
    }
    Button(
      onClick = { TrackedRepository.saveTracked(weightMetric.value) }) {
      Text(text = "Save")
    }
  }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun TrackComposablePreview() {
  TrackComposable()
}

object TrackComposable {
  val WEIGHT_INPUT = "WEIGHT_TEXT_FIELD_TAG"
}