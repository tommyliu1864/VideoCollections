package com.dongnaoedu.videocollections.logic.api

import com.dongnaoedu.videocollections.logic.di.NetWorkModule
import com.dongnaoedu.videocollections.logic.model.CommunityRecommend
import com.dongnaoedu.videocollections.logic.model.Follow
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * 社区
 */
interface CommunityService {

    /**
     * 社区-推荐列表
     */
    @GET
    suspend fun getCommunityRecommend(@Url url: String): CommunityRecommend

    /**
     * 社区-关注列表
     */
    @GET
    suspend fun getFollow(@Url url: String): Follow

    companion object {
        /**
         * 社区-推荐列表
         */
        const val COMMUNITY_RECOMMEND_URL = "${NetWorkModule.BASE_URL}api/v7/community/tab/rec"

        /**
         * 社区-关注列表
         */
        const val FOLLOW_URL = "${NetWorkModule.BASE_URL}api/v6/community/tab/follow"

    }

}