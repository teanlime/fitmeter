package com.teanlime.wellscore.track.stores

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
interface TrackedModule {

  @Binds
  @ActivityRetainedScoped
  fun bindTrackedRepository(inMemory: InMemoryTrackedRepository): TrackedRepository
}