package com.mercado.mercadolibretest.ui.sites.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.mercado.mercadolibretest.data.model.Sites
import com.mercado.mercadolibretest.data.repository.SitesRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import androidx.lifecycle.MutableLiveData

class SitesViewModel(private val sitesRepository: SitesRepository, private val  sitesData: SitesData) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private lateinit var userLiveData: MutableLiveData<ArrayList<Sites>>

    fun getSites() {

        compositeDisposable.add(
            sitesRepository.sites()
                .subscribeOn(Schedulers.single())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->

                    Log.e("Response", "Response: " + response[0].name)
                    userLiveData = MutableLiveData()
                    userLiveData.value = response
                    sitesData.onSuccess(response)


                }, { throwable ->
                    sitesData.onError(throwable.toString())
                    Log.e("error", "error: $throwable")
                })
        )
    }
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
    interface SitesData {
        fun onSuccess(list : ArrayList<Sites>)
        fun onError(messageError :String)
    }

}
