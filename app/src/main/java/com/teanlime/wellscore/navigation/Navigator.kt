package com.teanlime.wellscore.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.teanlime.wellscore.history.ui.HistoryComposable
import com.teanlime.wellscore.track.ui.TrackComposable

object Navigator {

  @Composable
  fun rememberWellScoreNavController(): NavHostController {
    return rememberNavController()
  }

  @Composable
  fun rememberWellScoreNavGraph(): NavGraph {
    val navController = rememberWellScoreNavController()

    return remember(navController) {
      navController.createGraph(startDestination = TrackNavigationRoute) {
        composable<TrackNavigationRoute> {
          TrackComposable()
        }
        composable<HistoryNavigationRoute> {
          HistoryComposable()
        }
      }
    }
  }
}