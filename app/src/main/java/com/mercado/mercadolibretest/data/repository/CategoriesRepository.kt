package com.mercado.mercadolibretest.data.repository

import com.mercado.mercadolibretest.data.api.MercadoService
import com.mercado.mercadolibretest.data.model.Locations
import io.reactivex.Single

class CategoriesRepository (private val mercadoService: MercadoService, private val idCat : String){
    fun categories(): Single<Locations> =mercadoService.getCategories(idCat)
}