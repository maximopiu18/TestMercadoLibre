package com.mercado.mercadolibretest

import android.app.Application
import android.content.Context
import com.mercado.mercadolibretest.data.api.MercadoService
import com.mercado.mercadolibretest.di.AppComponent
import com.mercado.mercadolibretest.di.AppModule
import com.mercado.mercadolibretest.di.DaggerAppComponent
import com.mercado.mercadolibretest.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class ApplicationMercado : Application() {


    var appComponent: AppComponent = DaggerAppComponent.create()


    override fun onCreate() {
        super.onCreate()
        instance = this

    }

    lateinit var instance: ApplicationMercado
        private set

    fun applicationContext(): Context {
        return instance.applicationContext
    }

    fun getRetrofitMercadoService(): MercadoService {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_MERCADO)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit.create(MercadoService::class.java)
    }

    companion object {

        fun getRetrofitMercadoService(): MercadoService {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL_MERCADO)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            return retrofit.create(MercadoService::class.java)
        }


    }



}