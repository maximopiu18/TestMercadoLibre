package com.mercado.mercadolibretest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mercado.mercadolibretest.ApplicationMercado
import com.mercado.mercadolibretest.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as ApplicationMercado).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}