package com.dongnaoedu.videocollections.logic.di

import android.app.Application
import androidx.room.Room
import com.dongnaoedu.videocollections.logic.db.AppDatabase
import com.dongnaoedu.videocollections.logic.db.SearchDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 *
 * @author ningchuanqi
 * @version V1.0
 */
@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideAppDataBase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "video_collections.db")
            .build()
    }

    @Singleton
    @Provides
    fun provideSearchDao(database: AppDatabase): SearchDao {
        return database.searchDao()
    }


}