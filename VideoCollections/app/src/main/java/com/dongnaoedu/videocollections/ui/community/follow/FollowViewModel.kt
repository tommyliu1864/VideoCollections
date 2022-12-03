package com.dongnaoedu.videocollections.ui.community.follow

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dongnaoedu.videocollections.logic.model.Follow
import com.dongnaoedu.videocollections.logic.repository.CommunityRepository
import kotlinx.coroutines.flow.Flow

class FollowViewModel @ViewModelInject constructor(
    val repository: CommunityRepository
) : ViewModel() {

    var dataList = ArrayList<Follow.Item>()

    fun getPagingData(): Flow<PagingData<Follow.Item>> {
        return repository.getFollowPagingData().cachedIn(viewModelScope)
    }
}