package com.teanlime.wellscore.track.model

import java.math.BigDecimal

data class Metric (
  val type: MetricType,
  val increments: BigDecimal = BigDecimal.valueOf(0.1),
  val label: String,
  val decimals: Int = 0,
  val normalizer: MetricNormalizer = MetricNormalizer.None,
  val displayNamePrefix: String = "",
  val displayNameSuffix: String = "",
  val upperBound: BigDecimal,
  val lowerBound: BigDecimal,
)

typealias MetricType = String

object StandardMetricTypes {
  const val METRIC: MetricType = "Metric"
  const val WEIGHT: MetricType = "Weight"
}
