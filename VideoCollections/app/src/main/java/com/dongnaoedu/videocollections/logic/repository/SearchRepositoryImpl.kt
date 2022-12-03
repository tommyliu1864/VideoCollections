package com.dongnaoedu.videocollections.logic.repository

import com.dongnaoedu.videocollections.logic.api.SearchService
import com.dongnaoedu.videocollections.logic.db.SearchDao
import com.dongnaoedu.videocollections.logic.entity.HotSearchEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * 搜索对应的仓库数据管理。
 */
class SearchRepositoryImpl(
    private val api: SearchService,
    private val dao: SearchDao,
) : SearchRepository {

    override fun getHotSearch(): Flow<List<String>> = flow {
        val response = api.getHotSearch()
        val hotSearches: List<HotSearchEntity> = response.map {
            HotSearchEntity(keyword = it)
        }
        // 缓存到本地数据库
        dao.clearHotSearch()
        dao.cacheHotSearch(hotSearches)
        emit(response)
    }
        .flowOn(Dispatchers.IO)

}