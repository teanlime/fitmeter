package com.teanlime.wellscore.track.stores

import com.teanlime.wellscore.track.model.MetricEntry
import com.teanlime.wellscore.track.model.MetricType
import kotlinx.coroutines.flow.Flow
import java.math.BigDecimal

interface TrackedRepository {
  suspend fun generateId(): Int
  suspend fun observeTracked(): Flow<List<MetricEntry>>
  suspend fun addNewTracked(metricEntry: MetricEntry)
  suspend fun modifyItem(id: MetricType, normalizedValueChange: BigDecimal)
}