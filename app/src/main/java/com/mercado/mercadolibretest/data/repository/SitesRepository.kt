package com.mercado.mercadolibretest.data.repository

import com.mercado.mercadolibretest.data.api.MercadoService
import com.mercado.mercadolibretest.data.model.Sites
import io.reactivex.Single

class SitesRepository (private val mercadoService: MercadoService){
    fun sites(): Single<ArrayList<Sites>> =mercadoService.getSites()
}