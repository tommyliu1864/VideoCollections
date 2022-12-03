package com.dongnaoedu.videocollections.ui.search

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.dongnaoedu.videocollections.logic.repository.SearchRepository
import kotlinx.coroutines.flow.Flow

class SearchViewModel @ViewModelInject constructor(
    repository: SearchRepository
) : ViewModel() {

    var dataList = ArrayList<String>()

    val data: Flow<List<String>> = repository.getHotSearch()
}