package com.mercado.mercadolibretest.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Results(

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("default_currency_id")
    val defaultCurrencyID: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("price")
    val price: String? = null,

    @field:SerializedName("currency_id")
    val currencyId: String? = null,

    @field:SerializedName("available_quantity")
    val availableQuantity: Int? = null,

    @field:SerializedName("sold_quantity")
    val soldQuantity: Int? = null,

    @field:SerializedName("thumbnail")
    val thumbnail: String? = null,
    @field:SerializedName("accepts_mercadopago")
    val acceptsMercadoPago: Boolean = false,

): Parcelable{

}
