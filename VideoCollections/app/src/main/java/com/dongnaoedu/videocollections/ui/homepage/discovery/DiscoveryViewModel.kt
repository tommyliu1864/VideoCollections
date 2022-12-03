package com.dongnaoedu.videocollections.ui.homepage.discovery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dongnaoedu.videocollections.logic.model.Discovery
import com.dongnaoedu.videocollections.logic.repository.HomePageRepository
import kotlinx.coroutines.flow.Flow

class DiscoveryViewModel @ViewModelInject constructor(
    val repository: HomePageRepository
) : ViewModel() {


    fun getPagingData(): Flow<PagingData<Discovery.Item>> {
        return repository.getDiscoveryPagingData().cachedIn(viewModelScope)
    }
}