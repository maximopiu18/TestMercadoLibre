package com.mercado.mercadolibretest.data.api

import com.mercado.mercadolibretest.data.model.Locations
import com.mercado.mercadolibretest.data.model.Products
import com.mercado.mercadolibretest.data.model.Sites
import io.reactivex.Single
import retrofit2.http.*


interface MercadoService {

    @Headers("Content-Type: application/json")
    @GET("sites/")
    fun getSites(): Single<ArrayList<Sites>>

    @GET("sites/{idLocation}/")
    fun getCategories(@Path("idLocation") idLocation: String): Single<Locations>

    @GET("sites/{idLocation}/search?")
    fun getProducts(@Path("idLocation") idLocation: String, @Query("category") idCategory: String,): Single<Products>

}