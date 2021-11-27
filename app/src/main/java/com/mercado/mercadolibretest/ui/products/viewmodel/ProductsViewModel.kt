package com.mercado.mercadolibretest.ui.products.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import androidx.lifecycle.MutableLiveData
import com.mercado.mercadolibretest.data.model.Results
import com.mercado.mercadolibretest.data.repository.ProductsRepository


class ProductsViewModel(private val productsRepository: ProductsRepository, private val  productsData: ProductsData) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    lateinit var categoriesLiveData: MutableLiveData<ArrayList<Results>>

    fun getProducts() {

        compositeDisposable.add(
            productsRepository.products()
                .subscribeOn(Schedulers.single())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    categoriesLiveData = MutableLiveData()
                    categoriesLiveData.value = response.results
                    productsData.onSuccess(response.results!!)


                }, { throwable ->
                    productsData.onError(throwable.toString())
                    // error
                    Log.e("error", "error: $throwable")
                })
        )
    }
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
    interface ProductsData {
        fun onSuccess(lista : ArrayList<Results>)
        fun onError(messageError :String)
    }

}
