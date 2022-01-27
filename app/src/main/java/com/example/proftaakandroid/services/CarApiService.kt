package com.example.proftaakandroid.services

import com.example.proftaakandroid.model.dataclasses.Car
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

interface CarApiService {
    @GET("cars")
    suspend fun getCars(): List<Car>

    @GET("cars/{id}")
    suspend fun getCar(@Path ("id") id: Int): Car

    @DELETE("cars/{id}")
    suspend fun deleteCar(@Path("id") id: Int): Response<Unit>

    @POST("cars/ice")
    suspend fun postCarIce(@Body car: Car): Car

    @POST("cars/ev")
    suspend fun postCarEv(@Body car: Car): Car
}

object CarApi {
    val retrofitService: CarApiService by lazy {
        retrofit.create(CarApiService::class.java)
    }
}