package com.dongnaoedu.videocollections.logic.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.dongnaoedu.videocollections.Const
import com.dongnaoedu.videocollections.logic.api.CommunityService
import com.dongnaoedu.videocollections.logic.model.CommunityRecommend
import com.dongnaoedu.videocollections.logic.model.Follow
import com.dongnaoedu.videocollections.ui.community.follow.FollowPagingSource
import com.dongnaoedu.videocollections.ui.community.recommend.RecommendPagingSource
import kotlinx.coroutines.flow.Flow

class CommunityRepositoryImpl constructor(
    private val communityService: CommunityService
) : CommunityRepository {

    override fun getCommunityRecommendPagingData(): Flow<PagingData<CommunityRecommend.Item>> {
        return Pager(
            config = PagingConfig(Const.Config.PAGE_SIZE),
            pagingSourceFactory = { RecommendPagingSource(communityService) }
        ).flow
    }

    override fun getFollowPagingData(): Flow<PagingData<Follow.Item>> {
        return Pager(
            config = PagingConfig(Const.Config.PAGE_SIZE),
            pagingSourceFactory = { FollowPagingSource(communityService) }
        ).flow
    }
}