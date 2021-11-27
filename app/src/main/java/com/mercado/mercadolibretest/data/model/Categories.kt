package com.mercado.mercadolibretest.data.model

import com.google.gson.annotations.SerializedName

data class Categories(
    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

)
