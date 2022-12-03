package com.dongnaoedu.videocollections.logic.repository

import kotlinx.coroutines.flow.Flow

/**
 *
 * @author ningchuanqi
 * @version V1.0
 */
interface SearchRepository {
    fun getHotSearch(): Flow<List<String>>
}