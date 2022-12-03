package com.dongnaoedu.videocollections.logic.repository

import androidx.paging.PagingData
import com.dongnaoedu.videocollections.logic.model.CommunityRecommend
import com.dongnaoedu.videocollections.logic.model.Follow
import kotlinx.coroutines.flow.Flow

interface CommunityRepository {

    fun getCommunityRecommendPagingData(): Flow<PagingData<CommunityRecommend.Item>>

    fun getFollowPagingData(): Flow<PagingData<Follow.Item>>
}