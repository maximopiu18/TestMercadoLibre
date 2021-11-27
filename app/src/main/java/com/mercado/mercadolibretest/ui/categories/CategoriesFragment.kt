package com.mercado.mercadolibretest.ui.categories

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mercado.mercadolibretest.ApplicationMercado
import com.mercado.mercadolibretest.BaseFragment
import com.mercado.mercadolibretest.R
import com.mercado.mercadolibretest.data.model.Categories
import com.mercado.mercadolibretest.data.repository.CategoriesRepository
import com.mercado.mercadolibretest.databinding.FragmentCategoriesBinding
import com.mercado.mercadolibretest.ui.categories.adapter.AdapterCategories
import com.mercado.mercadolibretest.ui.categories.factory.CategoriesViewModelFactory
import com.mercado.mercadolibretest.ui.categories.viewmodel.CategoriesViewModel



class CategoriesFragment : BaseFragment<FragmentCategoriesBinding>(R.layout.fragment_categories), CategoriesViewModel.CategoriesData, AdapterCategories.AdapterListener {

    private var retrofit = ApplicationMercado.getRetrofitMercadoService()
    private lateinit var binding: FragmentCategoriesBinding
    private lateinit var categoriesViewModel: CategoriesViewModel
    private var adapterCategories: AdapterCategories? = null
    val args: CategoriesFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        (requireActivity().applicationContext as ApplicationMercado).appComponent.inject(this)
        super.onCreate(savedInstanceState)

    }

    override fun FragmentCategoriesBinding.initialize(){
        binding = this
        setUpViewModel()
        setUpObserverCategories()
        listeners()
    }


    private fun setUpViewModel() {
        Log.e("id", "idrecibido" + args.idSite)
        categoriesViewModel = ViewModelProvider(this,
            CategoriesViewModelFactory(CategoriesRepository(retrofit, args.idSite), this)).get(CategoriesViewModel::class.java)
    }

    private fun setUpObserverCategories() {
        categoriesViewModel.getCategories()
    }

    override fun onSuccess(lista: ArrayList<Categories>) {
        Log.e("success", "success")
        uploadRvData(lista)
    }

    override fun onError(messageError: String) {
        Log.e("error", "error: $messageError" )
    }

    override fun listenerButtonOnClick(idCategory: String, tittle : String) {
        findNavController().navigate(CategoriesFragmentDirections.actionCategoriesFragmentToProductsFragment(args.idSite, idCategory,tittle))
    }

    private fun uploadRvData(lista: ArrayList<Categories>) {
        adapterCategories = AdapterCategories(lista, this)
        val mLayoutManager: RecyclerView.LayoutManager = GridLayoutManager(activity, 2)
        binding.fgSitesRvRegiones.layoutManager = mLayoutManager
        binding.fgSitesRvRegiones.setHasFixedSize(true)
        binding.fgSitesRvRegiones.adapter = adapterCategories
        binding.fgSitesRvRegiones.visibility = View.VISIBLE
    }
    private fun listeners(){
        binding.imgBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }


}