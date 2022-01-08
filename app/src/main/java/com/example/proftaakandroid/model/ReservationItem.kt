package com.example.proftaakandroid.model

import com.example.proftaakandroid.constants.FuelType
import com.squareup.moshi.Json

data class ReservationItem(

	@Json(name="ReservationItem")
	val reservationItem: List<ReservationItemItem?>? = null
)

data class Car(

	@Json(name="owner")
	val owner: Owner? = null,

	@Json(name="tco")
	val tco: Int? = null,

	@Json(name="fuelType")
	val fuelType: FuelType? = null,

	@Json(name="costsPerKM")
	val costsPerKM: Int? = null,

	@Json(name="model")
	val model: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="picture")
	val picture: String? = null
)

data class Seller(

	@Json(name="username")
	val username: String? = null
)

data class ReservationItemItem(

	@Json(name="endDate")
	val endDate: String? = null,

	@Json(name="listing")
	val listing: Listing? = null,

	@Json(name="startDate")
	val startDate: String? = null,

	@Json(name="buyer")
	val buyer: Buyer? = null
)

data class Listing(

	@Json(name="seller")
	val seller: Seller? = null,

	@Json(name="car")
	val car: Car? = null,

	@Json(name="endDate")
	val endDate: String? = null,

	@Json(name="location")
	val location: String? = null,

	@Json(name="startDate")
	val startDate: String? = null
)

data class Buyer(

	@Json(name="username")
	val username: String? = null
)

data class Owner(

	@Json(name="username")
	val username: String? = null
)
