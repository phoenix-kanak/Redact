package com.example.redact

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://rnmxd-2405-201-401a-e234-1ca-93a6-5266-b5b4.a.free.pinggy.link/")
    }

    @Provides
    @Singleton
    fun provideAPI(retrofitBuilder: Retrofit.Builder): API {
        return retrofitBuilder.build().create(API::class.java)
    }

}