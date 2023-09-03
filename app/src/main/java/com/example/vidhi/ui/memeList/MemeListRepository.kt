package com.example.vidhi.ui.memeList

import com.example.vidhi.network.response.MemeData
import com.example.vidhi.network.APIService
import javax.inject.Inject

/**
 * Meme list repository class
 *
 * @author Vidhi Dave
 */
class MemeListRepository @Inject constructor(private val service: APIService) {

    /**
     * API call to get all data
     */
    suspend fun getAllMemes(): MemeData {
        return service.getAllMemes()
    }

}