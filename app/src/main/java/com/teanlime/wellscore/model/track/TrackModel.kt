package com.teanlime.wellscore.model.track

typealias MetricType = String

data class Tracked (
  val metric: Metric, // Metric.WEIGHT
  val upperBound: Double, // “400.0”
  val lowerBound: Double, // “0.0”

  val value: Double) { // “65.6”

  fun increment(value: Double, incrementBy: Double = metric.increments): Tracked {
    return this
  }
  fun decrement(value: Double, decrementBy: Double = metric.increments): Tracked {
    return this
  }
  fun setTo(value: Double): Tracked {
    return this
  }
}

data class Metric (
  val id: MetricType, // “Weight”
  val displayNameSuffix: String, //”kg”
  val displayNamePrefix: String, // “”
  val increments: Double, // “0.1”
  val normalizer: MetricNormalizer,  //MetricNormalizer.None<Double>
  val decimals: Int, // “1”
)

sealed class MetricNormalizer {
  abstract fun convertToDisplayValue(value: Double): Double
  abstract fun convertFromDisplayValue(value: Double): Double

  data object None: MetricNormalizer() {
    override fun convertToDisplayValue(value: Double) = value
    override fun convertFromDisplayValue(value: Double) = value
  }
}

sealed class MetricSystemDefinitions(
  val id: MetricType, // “Metric”
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
        increments = 0.1,
        decimals = 1,
        normalizer = MetricNormalizer.None
    )
  ))

  companion object {
    val METRIC: MetricType = "Metric"
    val WEIGHT: MetricType = "Weight"
  }
}
