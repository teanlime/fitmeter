package com.teanlime.wellscore.track.model

import java.math.BigDecimal

data class MetricEntry (
  val id: TrackedId,
  val metric: Metric,
  val timestamp: Long,

  val value: BigDecimal) {

  val normalizedValue: BigDecimal get() = metric.normalizer.convertToDisplayValue(value)

  val normalizedDisplayValue = "${metric.displayNamePrefix} $normalizedValue ${metric.displayNameSuffix}"

  fun increment(incrementBy: BigDecimal = metric.increments): MetricEntry {
    return this.copy(value = metric.normalizer.convertToDisplayValue(value + incrementBy))
  }
  fun decrement(decrementBy: BigDecimal = metric.increments): MetricEntry {
    return this.copy(value = metric.normalizer.convertToDisplayValue(value - decrementBy))
  }
  fun setTo(value: BigDecimal): MetricEntry {
    return this.copy(value = metric.normalizer.convertFromDisplayValue(value))
  }
}

typealias TrackedId = String