package com.example.vidhi.network

import com.example.vidhi.network.response.MemeData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/*
 * API service class - List of API call methods
 *
 * @author Vidhi Dave
 */
class APIService @Inject constructor(private val api: APIClient) {

    suspend fun getAllMemes(): MemeData {
        return withContext(Dispatchers.IO) {
            api.getAllMemes()
        }
    }
}