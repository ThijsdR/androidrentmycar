package com.example.proftaakandroid

import com.example.proftaakandroid.model.Car
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

//private const val BASE_URL = "https://jsonplaceholder.typicode.com"
private const val BASE_URL = "http://10.0.2.2:8080/v1/"
//private const val BASE_URL = "http://localhost:8080/v1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface CarApiService {
    //TODO add functions from API
    //Examples:

    @GET("cars")
    suspend fun getCars(): List<Car>

    @DELETE("cars/{id}")
    suspend fun deleteItem(@Path("id") todoId: Int)

    @POST("cars")
    suspend fun postItem(@Body car: Car): Car
}

object CarApi {
    val retrofitService: CarApiService by lazy {
        retrofit.create(CarApiService::class.java)
    }
}