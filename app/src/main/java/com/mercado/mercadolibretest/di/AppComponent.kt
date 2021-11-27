package com.mercado.mercadolibretest.di

import com.mercado.mercadolibretest.ApplicationMercado
import com.mercado.mercadolibretest.ui.MainActivity
import com.mercado.mercadolibretest.ui.categories.CategoriesFragment
import com.mercado.mercadolibretest.ui.details.DetailsProductFragment
import com.mercado.mercadolibretest.ui.sites.SitesFragment
import com.mercado.mercadolibretest.ui.products.ProductsFragment
import com.mercado.mercadolibretest.ui.splash.SplashFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(application: ApplicationMercado)
    fun inject(mainActivity: MainActivity)
    fun inject(splash: SplashFragment)
    fun inject(productsFragment: ProductsFragment)
    fun inject(sites: SitesFragment)
    fun inject(categories: CategoriesFragment)
    fun inject(detailsProductFragment: DetailsProductFragment)

}