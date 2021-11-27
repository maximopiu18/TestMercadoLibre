package com.mercado.mercadolibretest.ui.categories.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import androidx.lifecycle.MutableLiveData
import com.mercado.mercadolibretest.data.model.Categories
import com.mercado.mercadolibretest.data.repository.CategoriesRepository


class CategoriesViewModel(private val categoriesRepository: CategoriesRepository, private val  categoriesData: CategoriesData) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    lateinit var categoriesLiveData: MutableLiveData<ArrayList<Categories>>

    fun getCategories() {

        compositeDisposable.add(
            categoriesRepository.categories()
                .subscribeOn(Schedulers.single())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->

                    Log.e("Response", "Response: " + response.categories!!.size)
                    categoriesLiveData = MutableLiveData()
                    categoriesLiveData.value = response.categories
                    categoriesData.onSuccess(response.categories)


                }, { throwable ->
                    categoriesData.onError(throwable.toString())
                    // error
                    Log.e("error", "error: $throwable")
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
    interface CategoriesData {
        fun onSuccess(lista : ArrayList<Categories>)
        fun onError(messageError :String)
    }

}
