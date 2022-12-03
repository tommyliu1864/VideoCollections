package com.dongnaoedu.videocollections.extension

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.dongnaoedu.videocollections.VideoCollectionsApplication

/**
 * 获取DataStore实例
 */

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = VideoCollectionsApplication.context.packageName + "_preferences",
    produceMigrations = { context ->
        listOf(SharedPreferencesMigration(context, VideoCollectionsApplication.context.packageName + "_preferences"))
    })