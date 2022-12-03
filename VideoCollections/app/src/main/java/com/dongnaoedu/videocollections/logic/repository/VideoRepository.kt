package com.dongnaoedu.videocollections.logic.repository

import com.dongnaoedu.videocollections.logic.model.VideoDetail
import com.dongnaoedu.videocollections.logic.model.VideoReplies

interface VideoRepository {

    suspend fun getVideoReplies(url: String): VideoReplies

    suspend fun getVideoRelatedAndVideoReplies(videoId: Long, repliesUrl: String): VideoDetail

    suspend fun getVideoDetail(videoId: Long, repliesUrl: String): VideoDetail
}