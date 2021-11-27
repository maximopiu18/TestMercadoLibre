package com.mercado.mercadolibretest.data.model

import com.google.gson.annotations.SerializedName

data class Locations(
    @field:SerializedName("id")
    val id: String? = null,
    @field:SerializedName("name")
    val name: String? = null,
    @field:SerializedName("country_id")
    val countryId: String? = null,
    @field:SerializedName("not_free")
    val notFree: String? = null,
    @field:SerializedName("mercadopago_version")
    val mercadopagoVersion: String? = null,
    @field:SerializedName("default_currency_id")
    val defaultCurrencyId: String? = null,
    @field:SerializedName("immediate_payment")
    val immediatePayment: String? = null,
    @field:SerializedName("payment_method_ids")
    val paymentMethodIds: ArrayList<String>? = null,
    @field:SerializedName("categories")
    val categories: ArrayList<Categories>? = null,
)
