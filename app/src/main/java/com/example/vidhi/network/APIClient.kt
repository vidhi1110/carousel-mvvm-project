package com.example.vidhi.network

import com.example.vidhi.network.response.MemeData
import retrofit2.http.GET

/*
 * API client class - List of API call methods
 *
 * @author Vidhi Dave
 */
interface APIClient {

    @GET("get_memes")
    suspend fun getAllMemes(): MemeData

}