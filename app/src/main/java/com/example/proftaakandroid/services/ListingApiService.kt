package com.example.proftaakandroid.services

import com.example.proftaakandroid.model.dataclasses.Listing
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

private const val BASE_URL = "http://10.0.2.2:8080/v1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ListingApiService {
    @GET("listings")
    suspend fun getListings(): List<Listing>

    @GET("listings/{id}")
    suspend fun getListing(@Path("id") id: Int): Listing

    @DELETE("listings/{id}")
    suspend fun deleteListing(@Path("id") id: Int): Response<Unit>

    @POST("listings")
    suspend fun postListing(@Body listing: Listing): Listing
}

object ListingApi {
    val retrofitService: ListingApiService by lazy {
        retrofit.create(ListingApiService::class.java)
    }
}