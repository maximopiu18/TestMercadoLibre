package com.mercado.mercadolibretest.data.repository

import com.mercado.mercadolibretest.data.api.MercadoService
import com.mercado.mercadolibretest.data.model.Products
import io.reactivex.Single

class ProductsRepository (private val mercadoService: MercadoService, private val idLocation : String, private val idCategory : String){
    fun products(): Single<Products> =mercadoService.getProducts(idLocation, idCategory)
}