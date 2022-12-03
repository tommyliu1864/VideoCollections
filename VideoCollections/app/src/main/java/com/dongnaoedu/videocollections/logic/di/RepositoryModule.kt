package com.dongnaoedu.videocollections.logic.di

import com.dongnaoedu.videocollections.logic.api.*
import com.dongnaoedu.videocollections.logic.db.SearchDao
import com.dongnaoedu.videocollections.logic.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@InstallIn(ActivityComponent::class)
@Module
object RepositoryModule {

    @ActivityScoped
    @Provides
    fun provideSearchRepository(
        api: SearchService,
        dao: SearchDao
    ): SearchRepository {
        return SearchRepositoryImpl(api, dao)
    }

    @ActivityScoped
    @Provides
    fun provideHomePageRepository(
        api: HomePageService,
    ): HomePageRepository {
        return HomePageRepositoryImpl(api)
    }

    @ActivityScoped
    @Provides
    fun provideVideoRepository(
        api: VideoService,
    ): VideoRepository {
        return VideoRepositoryImpl(api)
    }

    @ActivityScoped
    @Provides
    fun provideCommunityRepository(
        api: CommunityService,
    ): CommunityRepository {
        return CommunityRepositoryImpl(api)
    }

    @ActivityScoped
    @Provides
    fun provideNotificationRepository(
        api: NotificationService,
    ): NotificationRepository {
        return NotificationRepositoryImpl(api)
    }
}