package com.dongnaoedu.videocollections.ui.community.recommend

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dongnaoedu.videocollections.logic.model.CommunityRecommend
import com.dongnaoedu.videocollections.logic.repository.CommunityRepository
import kotlinx.coroutines.flow.Flow

class RecommendViewModel @ViewModelInject constructor(
    val repository: CommunityRepository
) : ViewModel() {

    var dataList = ArrayList<CommunityRecommend.Item>()

    fun getPagingData(): Flow<PagingData<CommunityRecommend.Item>> {
        return repository.getCommunityRecommendPagingData().cachedIn(viewModelScope)
    }
}