package com.dongnaoedu.videocollections.logic.db
import androidx.room.Database
import androidx.room.RoomDatabase
import com.dongnaoedu.videocollections.logic.entity.HotSearchEntity

/**
 * 应用程序所有Dao操作管理类。
 */
@Database(
    entities = [HotSearchEntity::class],
    version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun searchDao(): SearchDao

    abstract fun homePageDao(): HomePageDao
}