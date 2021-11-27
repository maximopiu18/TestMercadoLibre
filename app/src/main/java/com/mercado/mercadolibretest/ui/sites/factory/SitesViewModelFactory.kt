package com.mercado.mercadolibretest.ui.sites.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mercado.mercadolibretest.data.repository.SitesRepository
import com.mercado.mercadolibretest.ui.sites.viewmodel.SitesViewModel

@Suppress("UNCHECKED_CAST")
class SitesViewModelFactory(private val sitesRepository: SitesRepository, private val sitesData : SitesViewModel.SitesData) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(SitesViewModel::class.java)) {
            SitesViewModel(this.sitesRepository, sitesData) as T
        } else throw IllegalArgumentException("No se encontró la clase")
    }
}
