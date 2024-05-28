package com.teanlime.wellscore.track.model

import java.math.BigDecimal

sealed class MetricNormalizer {
  abstract fun convertToDisplayValue(value: BigDecimal): BigDecimal
  abstract fun convertFromDisplayValue(value: BigDecimal): BigDecimal

  data object None: MetricNormalizer() {
    override fun convertToDisplayValue(value: BigDecimal) = value
    override fun convertFromDisplayValue(value: BigDecimal) = value
  }
}