package com.dongnaoedu.videocollections.ui.notification.push

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dongnaoedu.videocollections.logic.model.PushMessage
import com.dongnaoedu.videocollections.logic.repository.NotificationRepository
import kotlinx.coroutines.flow.Flow

class PushViewModel @ViewModelInject constructor(
    val repository: NotificationRepository
) : ViewModel() {

    var dataList = ArrayList<PushMessage.Message>()

    fun getPagingData(): Flow<PagingData<PushMessage.Message>> {
        return repository.getMessagePagingData().cachedIn(viewModelScope)
    }
}
