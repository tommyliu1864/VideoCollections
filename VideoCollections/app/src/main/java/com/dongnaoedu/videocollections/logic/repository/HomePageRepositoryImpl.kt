package com.dongnaoedu.videocollections.logic.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.dongnaoedu.videocollections.Const
import com.dongnaoedu.videocollections.logic.api.HomePageService
import com.dongnaoedu.videocollections.logic.model.Daily
import com.dongnaoedu.videocollections.logic.model.Discovery
import com.dongnaoedu.videocollections.logic.model.HomePageRecommend
import com.dongnaoedu.videocollections.ui.homepage.recommend.RecommendPagingSource
import com.dongnaoedu.videocollections.ui.homepage.daily.DailyPagingSource
import com.dongnaoedu.videocollections.ui.homepage.discovery.DiscoveryPagingSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

/**
 * 主页界面，主要包含：（首页，社区，通知，我的），对应的仓库数据管理。
 */
class HomePageRepositoryImpl constructor(
    private val homePageService: HomePageService
) : HomePageRepository {

    override fun getDiscoveryPagingData(): Flow<PagingData<Discovery.Item>> {
        return Pager(
            config = PagingConfig(Const.Config.PAGE_SIZE),
            pagingSourceFactory = { DiscoveryPagingSource(homePageService) }
        ).flow.flowOn(Dispatchers.IO)
    }

    override fun getHomePageRecommendPagingData(): Flow<PagingData<HomePageRecommend.Item>> {
        return Pager(
            config = PagingConfig(Const.Config.PAGE_SIZE),
            pagingSourceFactory = { RecommendPagingSource(homePageService) }
        ).flow.flowOn(Dispatchers.IO)
    }

    override fun getDailyPagingData(): Flow<PagingData<Daily.Item>> {
        return Pager(
            config = PagingConfig(Const.Config.PAGE_SIZE),
            pagingSourceFactory = { DailyPagingSource(homePageService) }
        ).flow.flowOn(Dispatchers.IO)
    }

}