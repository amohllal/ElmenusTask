package com.example.data.di

import android.app.Application
import com.example.data.core.HOME_BASE
import com.example.data.core.HOME_BASE_URL
import com.example.data.core.MEALS_BASE
import com.example.data.core.MEALS_BASE_URL
import com.example.data.core.NetworkConnectionInterceptor
import com.example.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        networkConnectionInterceptor: NetworkConnectionInterceptor
    ): OkHttpClient =
        OkHttpClient()
            .newBuilder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(networkConnectionInterceptor)
            .writeTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(5, TimeUnit.MINUTES)
            .build()


    @Provides
    @Named(HOME_BASE)
    fun provideHomeBaseUrlRetrofit(okHttpClient: OkHttpClient): ApiService =
        Retrofit.Builder()
            .baseUrl(HOME_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    @Provides
    @Named(MEALS_BASE)
    fun provideMealsBaseUrlRetrofit(okHttpClient: OkHttpClient): ApiService =
        Retrofit.Builder()
            .baseUrl(MEALS_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    @Provides
    fun provideInterceptor(): Interceptor =
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun provideNetworkConnectionInterceptor(appContext: Application): NetworkConnectionInterceptor =
        NetworkConnectionInterceptor(appContext)

    @Provides
    fun loggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }
}