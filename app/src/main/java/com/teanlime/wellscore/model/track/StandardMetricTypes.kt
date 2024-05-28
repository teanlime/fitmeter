package com.teanlime.wellscore.model.track

import com.teanlime.wellscore.model.track.StandardMetricTypes.METRIC
import com.teanlime.wellscore.model.track.StandardMetricTypes.WEIGHT
import java.math.BigDecimal

typealias MetricType = String

data class Tracked (
  val metric: Metric,
  val upperBound: BigDecimal,
  val lowerBound: BigDecimal,

  val value: BigDecimal) {

  val normalizedValue: BigDecimal get() = metric.normalizer.convertToDisplayValue(value)

  fun increment(incrementBy: BigDecimal = metric.increments): Tracked {
    return this.copy(value = metric.normalizer.convertToDisplayValue(value + incrementBy))
  }
  fun decrement(decrementBy: BigDecimal = metric.increments): Tracked {
    return this.copy(value = metric.normalizer.convertToDisplayValue(value - decrementBy))
  }
  fun setTo(value: BigDecimal): Tracked {
    return this.copy(value = metric.normalizer.convertToDisplayValue(value))
  }
}

data class Metric (
  val id: MetricType,
  val increments: BigDecimal = BigDecimal.valueOf(0.1),
  val decimals: Int = 0,
  val normalizer: MetricNormalizer = MetricNormalizer.None,
  val displayNamePrefix: String = "",
  val displayNameSuffix: String = "",
)

sealed class MetricNormalizer {
  abstract fun convertToDisplayValue(value: BigDecimal): BigDecimal
  abstract fun convertFromDisplayValue(value: BigDecimal): BigDecimal

  data object None: MetricNormalizer() {
    override fun convertToDisplayValue(value: BigDecimal) = value
    override fun convertFromDisplayValue(value: BigDecimal) = value
  }
}

sealed class MetricSystemDefinitions(
  val id: MetricType,
  val displayName: String,
  val definitions: Map<MetricType, Metric>
)
{
  data object MetricSystemDefinition: MetricSystemDefinitions(
    id = METRIC,
    displayName = "Metric",
    definitions = mapOf(
      WEIGHT to Metric(
        id = WEIGHT,
        displayNameSuffix = "kg",
        displayNamePrefix = "",
        increments = BigDecimal.valueOf(0.1),
        decimals = 1,
        normalizer = MetricNormalizer.None
    )
  ))
}

object StandardMetricTypes {
  val METRIC: MetricType = "Metric"
  val WEIGHT: MetricType = "Weight"
}
