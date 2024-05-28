package com.teanlime.wellscore.model.track

import androidx.compose.runtime.mutableStateListOf

object TrackedRepository {

  val tracks = mutableStateListOf<Tracked>()

  fun saveTracked(tracked: Tracked) {
    tracks.add(tracked)
  }
}