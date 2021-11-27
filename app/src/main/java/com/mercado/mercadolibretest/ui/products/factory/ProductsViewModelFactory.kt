package com.mercado.mercadolibretest.ui.products.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mercado.mercadolibretest.data.repository.ProductsRepository
import com.mercado.mercadolibretest.ui.products.viewmodel.ProductsViewModel

@Suppress("UNCHECKED_CAST")
class ProductsViewModelFactory(private val productsRepository: ProductsRepository,
                               private val productsData : ProductsViewModel.ProductsData) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ProductsViewModel::class.java)) {
            ProductsViewModel(this.productsRepository, productsData) as T
        } else throw IllegalArgumentException("No se encontró la clase")
    }
}
