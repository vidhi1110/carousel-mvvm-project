package com.example.vidhi.di

import com.example.vidhi.BuildConfig
import com.example.vidhi.network.APIClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ActivityComponent::class)
object NetworkModule {

    /**
     * Creating retrofit builder for API calls
     */
    @Provides
    fun provideRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val clientLogging: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(clientLogging)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideAPIClient(retrofit: Retrofit): APIClient {
        return retrofit.create(APIClient::class.java)
    }

}