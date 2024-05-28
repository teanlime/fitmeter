package com.teanlime.wellscore.track.model

import com.teanlime.wellscore.track.model.StandardMetricTypes.METRIC
import com.teanlime.wellscore.track.model.StandardMetricTypes.WEIGHT
import java.math.BigDecimal

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
        type = WEIGHT,
        label = "Weight",
        displayNameSuffix = "kg",
        displayNamePrefix = "",
        increments = BigDecimal.valueOf(0.1),
        decimals = 1,
        normalizer = MetricNormalizer.None,
        upperBound = BigDecimal.valueOf(400.0),
        lowerBound = BigDecimal.valueOf(20.0),
    )
  ))
}
