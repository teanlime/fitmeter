package com.teanlime.wellscore.track.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teanlime.wellscore.track.model.MetricEntry
import com.teanlime.wellscore.track.model.MetricSystemDefinitions.MetricSystemDefinition
import com.teanlime.wellscore.track.model.StandardMetricTypes.WEIGHT
import com.teanlime.wellscore.track.stores.InMemoryTrackedRepository
import com.teanlime.wellscore.track.stores.TrackedRepository
import kotlinx.coroutines.launch
import java.math.BigDecimal

class TrackViewModel(
  private val trackedRepository: TrackedRepository = InMemoryTrackedRepository
) : ViewModel() {

  private var nextId = 0

  fun onAddClicked() {
    viewModelScope.launch {
      trackedRepository.addNewTracked(
        MetricEntry(
          id = nextId++.toString(),
          metric = MetricSystemDefinition.definitions[WEIGHT]!!,
          timestamp = 0L,
          value = BigDecimal.valueOf(nextId * 15L)
        )
      )
    }
  }
}