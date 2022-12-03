package com.dongnaoedu.videocollections.ui.homepage.discovery

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dongnaoedu.videocollections.logic.api.HomePageService
import com.dongnaoedu.videocollections.logic.model.Discovery

class DiscoveryPagingSource(private val homePageService: HomePageService) : PagingSource<String, Discovery.Item>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Discovery.Item> {
        return try {
            val page = params.key ?: HomePageService.DISCOVERY_URL
            val repoResponse = homePageService.getDiscovery(page)
            val repoItems = repoResponse.itemList
            val prevKey = null
            val nextKey = if (repoItems.isNotEmpty() && !repoResponse.nextPageUrl.isNullOrEmpty()) repoResponse.nextPageUrl else null
            LoadResult.Page(repoItems, prevKey, nextKey)
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<String, Discovery.Item>): String? = null
}