package com.teanlime.wellscore.history.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teanlime.wellscore.track.stores.InMemoryTrackedRepository
import com.teanlime.wellscore.track.stores.TrackedRepository
import kotlinx.coroutines.launch
import java.math.BigDecimal

class HistoryViewModel(
  private val trackedRepository: TrackedRepository = InMemoryTrackedRepository
) : ViewModel() {

  private val _historyState = mutableStateListOf<HistoryUiState>()
  val historyState: SnapshotStateList<HistoryUiState> = _historyState
  init {
    viewModelScope.launch {
      trackedRepository.observeTracked().collect { metricEntries ->
        _historyState.clear()
        _historyState.addAll(metricEntries.map { metricEntry -> HistoryUiState(
          id = metricEntry.id,
          timestamp = metricEntry.timestamp,
          label = metricEntry.metric.label,
          value = metricEntry.normalizedDisplayValue
        ) })
      }
    }
  }

  val onHistoryItemClicked =  { selectedId: String ->
    viewModelScope.launch {
      trackedRepository.modifyItem(
        id = selectedId,
        normalizedValueChange = BigDecimal.ONE
      )
    }
    Unit
  }
}