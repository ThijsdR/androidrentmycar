package com.example.proftaakandroid.model.dataclasses

import com.squareup.moshi.Json

data class User(

	@Json(name="username")
	val username: String? = null
)