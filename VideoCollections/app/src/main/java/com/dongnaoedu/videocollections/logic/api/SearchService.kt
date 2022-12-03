package com.dongnaoedu.videocollections.logic.api

import retrofit2.http.GET

/**
 * 主页界面，主要包含：（首页，社区，通知，我的）对应的 API 接口。
 */
interface SearchService {

    /**
     * 搜索-热搜关键词
     */
    @GET("api/v3/queries/hot")
    suspend fun getHotSearch(): List<String>

}