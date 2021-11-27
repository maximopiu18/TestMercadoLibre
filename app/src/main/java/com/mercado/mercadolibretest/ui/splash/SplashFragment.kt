package com.mercado.mercadolibretest.ui.splash

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.mercado.mercadolibretest.R
import kotlinx.coroutines.*



class SplashFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_splash, container, false)
        initTime()
        return view
    }

    private fun initTime(){
        lifecycleScope.launch {
            withContext(Dispatchers.Main) {
                delay(3000)
                try {
                    withContext(Dispatchers.Main) {
                        findNavController().navigate(R.id.action_splashFragment_to_sitesFragment)

                    }
                } catch (e:Exception){
                    Log.e("error", "$e")
                }
            }
        }
    }

}