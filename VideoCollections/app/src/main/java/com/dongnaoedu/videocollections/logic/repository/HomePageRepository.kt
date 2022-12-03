package com.dongnaoedu.videocollections.logic.repository

import androidx.paging.PagingData
import com.dongnaoedu.videocollections.logic.model.Daily
import com.dongnaoedu.videocollections.logic.model.Discovery
import com.dongnaoedu.videocollections.logic.model.HomePageRecommend
import kotlinx.coroutines.flow.Flow

interface HomePageRepository {
    fun getDiscoveryPagingData(): Flow<PagingData<Discovery.Item>>

    fun getHomePageRecommendPagingData(): Flow<PagingData<HomePageRecommend.Item>>

    fun getDailyPagingData(): Flow<PagingData<Daily.Item>>
}