package com.mercado.mercadolibretest.data.model

import com.google.gson.annotations.SerializedName

data class Products(
    @field:SerializedName("site_id")
    val siteId: String? = "",

    @field:SerializedName("country_default_time_zone")
    val countryDefaultTimeZone: String? = "",

    @field:SerializedName("results")
    val results: ArrayList<Results>? = null

)
