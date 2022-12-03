package com.dongnaoedu.videocollections.ui.community.follow

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dongnaoedu.videocollections.logic.api.CommunityService
import com.dongnaoedu.videocollections.logic.model.Follow

class FollowPagingSource(private val communityService: CommunityService) : PagingSource<String, Follow.Item>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Follow.Item> {
        return try {
            val page = params.key ?: CommunityService.FOLLOW_URL
            val repoResponse = communityService.getFollow(page)
            val repoItems = repoResponse.itemList
            val prevKey = null
            val nextKey = if (repoItems.isNotEmpty() && !repoResponse.nextPageUrl.isNullOrEmpty()) repoResponse.nextPageUrl else null
            LoadResult.Page(repoItems, prevKey, nextKey)
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<String, Follow.Item>): String? = null
}