package com.dongnaoedu.videocollections.logic.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.dongnaoedu.videocollections.Const
import com.dongnaoedu.videocollections.logic.api.NotificationService
import com.dongnaoedu.videocollections.logic.model.PushMessage
import com.dongnaoedu.videocollections.ui.notification.push.PushPagingSource
import kotlinx.coroutines.flow.Flow

class NotificationRepositoryImpl(
    private val notificationService: NotificationService
) : NotificationRepository {

    override fun getMessagePagingData(): Flow<PagingData<PushMessage.Message>> {
        return Pager(
            config = PagingConfig(Const.Config.PAGE_SIZE),
            pagingSourceFactory = { PushPagingSource(notificationService) }
        ).flow
    }
}