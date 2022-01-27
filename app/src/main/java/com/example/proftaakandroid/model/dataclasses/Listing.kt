package com.example.proftaakandroid.model.dataclasses

import com.squareup.moshi.Json

data class Listing(

    @Json(name="seller")
	val seller: User? = null,

    @Json(name="car")
	val car: Car? = null,

    @Json(name="endDate")
	val endDate: String? = null,

    @Json(name="location")
	val location: String? = null,

    @Json(name="startDate")
	val startDate: String? = null
)