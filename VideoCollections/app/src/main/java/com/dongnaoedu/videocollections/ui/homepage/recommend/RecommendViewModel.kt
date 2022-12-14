package com.dongnaoedu.videocollections.ui.homepage.recommend

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dongnaoedu.videocollections.logic.model.HomePageRecommend
import com.dongnaoedu.videocollections.logic.repository.HomePageRepository
import kotlinx.coroutines.flow.Flow

class RecommendViewModel @ViewModelInject constructor(
    val repository: HomePageRepository
) : ViewModel() {

    var dataList = ArrayList<HomePageRecommend.Item>()

    fun getPagingData(): Flow<PagingData<HomePageRecommend.Item>> {
        return repository.getHomePageRecommendPagingData().cachedIn(viewModelScope)
    }
}
