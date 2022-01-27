package com.example.proftaakandroid.model.dataclasses

import com.squareup.moshi.Json

data class Reservation(

    @Json(name="endDate")
	val endDate: String? = null,

    @Json(name="listing")
	val listing: Listing? = null,

    @Json(name="startDate")
	val startDate: String? = null,

    @Json(name="buyer")
	val buyer: User? = null
)