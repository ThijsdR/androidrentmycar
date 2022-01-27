package com.example.proftaakandroid.model.dataclasses

import com.example.proftaakandroid.constants.FuelType
import com.squareup.moshi.Json

data class Car(

	@Json(name="owner")
	val owner: User? = null,

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