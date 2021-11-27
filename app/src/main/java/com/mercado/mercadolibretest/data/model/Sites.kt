package com.mercado.mercadolibretest.data.model

import com.google.gson.annotations.SerializedName

data class Sites(
    @field:SerializedName("default_currency_id")
    val defaultCurrencyID: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

)
