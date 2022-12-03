package com.dongnaoedu.videocollections.logic.repository

import androidx.paging.PagingData
import com.dongnaoedu.videocollections.logic.model.PushMessage
import kotlinx.coroutines.flow.Flow

interface NotificationRepository {

    fun getMessagePagingData(): Flow<PagingData<PushMessage.Message>>
}