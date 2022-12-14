package com.dongnaoedu.videocollections.logic.api

import com.dongnaoedu.videocollections.logic.di.NetWorkModule
import com.dongnaoedu.videocollections.logic.model.PushMessage
import retrofit2.http.GET
import retrofit2.http.Url

interface NotificationService {

    /**
     * 通知-推送列表
     */
    @GET
    suspend fun getPushMessage(@Url url: String): PushMessage

    companion object {
        /**
         * 通知-推送列表
         */
        const val PUSHMESSAGE_URL = "${NetWorkModule.BASE_URL}api/v3/messages"
    }

}