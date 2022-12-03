package com.dongnaoedu.videocollections.logic.db

import androidx.room.*
import com.dongnaoedu.videocollections.logic.entity.HotSearchEntity

/**
 * 主页界面（主要包含：首页，社区，通知，我的），对应的Dao操作类。
 */
@Dao
interface SearchDao {


    /*----------------------------搜索相关----------------------------*/
    @Query("DELETE FROM HotSearchEntity")
    suspend fun clearHotSearch()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun cacheHotSearch(bean: List<HotSearchEntity>?)

}