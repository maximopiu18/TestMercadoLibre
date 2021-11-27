package com.mercado.mercadolibretest.di

import com.mercado.mercadolibretest.data.model.Locations
import com.mercado.mercadolibretest.data.model.Sites
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun providesLocations() : ArrayList<Locations> = arrayListOf(Locations())

    @Provides
    @Singleton
    fun providesSites() : ArrayList<Sites> = arrayListOf(Sites())


}