package com.mercado.mercadolibretest.ui.categories.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mercado.mercadolibretest.data.repository.CategoriesRepository
import com.mercado.mercadolibretest.ui.categories.viewmodel.CategoriesViewModel

@Suppress("UNCHECKED_CAST")
class CategoriesViewModelFactory(private val categoriesRepository: CategoriesRepository,
                                 private val categoriesData : CategoriesViewModel.CategoriesData) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(CategoriesViewModel::class.java)) {
            CategoriesViewModel(this.categoriesRepository, categoriesData) as T
        } else throw IllegalArgumentException("No se encontró la clase")
    }
}
