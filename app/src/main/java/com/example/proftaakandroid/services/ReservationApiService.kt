package com.example.proftaakandroid.services

import com.example.proftaakandroid.model.dataclasses.Reservation
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

interface ReservationApiService {
    @GET("reservations")
    suspend fun getReservations(): List<Reservation>

    @GET("reservations/{id}")
    suspend fun getReservation(@Path ("id") id: Int): Reservation

    @DELETE("reservations/{id}")
    suspend fun deleteReservation(@Path("id") id: Int): Response<Unit>

    @POST("reservations")
    suspend fun postReservation(@Body reservation: Reservation): Reservation
}

object ReservationApi {
    val retrofitService: ReservationApiService by lazy {
        retrofit.create(ReservationApiService::class.java)
    }
}