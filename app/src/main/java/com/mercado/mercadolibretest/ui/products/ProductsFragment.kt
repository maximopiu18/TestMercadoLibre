package com.mercado.mercadolibretest.ui.products

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
import com.mercado.mercadolibretest.data.model.Results
import com.mercado.mercadolibretest.data.repository.ProductsRepository
import com.mercado.mercadolibretest.databinding.FragmentProductsBinding
import com.mercado.mercadolibretest.ui.products.adapter.AdapterProducts
import com.mercado.mercadolibretest.ui.products.factory.ProductsViewModelFactory
import com.mercado.mercadolibretest.ui.products.viewmodel.ProductsViewModel


class ProductsFragment : BaseFragment<FragmentProductsBinding>(R.layout.fragment_products), ProductsViewModel.ProductsData, AdapterProducts.AdapterListener {

    private var retrofit = ApplicationMercado.getRetrofitMercadoService()
    private lateinit var binding: FragmentProductsBinding
    private lateinit var productsViewModel: ProductsViewModel
    private var adapterProducts: AdapterProducts? = null
    private val args: ProductsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        //(requireActivity().applicationContext as ApplicationMercado).appComponent.inject(this)
        getComponent().inject(this)
        super.onCreate(savedInstanceState)

    }

    override fun FragmentProductsBinding.initialize(){
        binding = this
        setUpViewModel()
        setUpObserverProducts()
        listeners()
    }


    private fun setUpViewModel() {
        productsViewModel = ViewModelProvider(this, ProductsViewModelFactory(ProductsRepository(retrofit, args.idLocation, args.idCategory),
            this)).get(ProductsViewModel::class.java)
    }

    private fun setUpObserverProducts() {
        productsViewModel.getProducts()
    }

    override fun onSuccess(lista: ArrayList<Results>) {
        uploadRvData(lista)
    }

    override fun onError(messageError: String) {
        Log.e("error", "error: $messageError")
    }

    private fun uploadRvData(list: ArrayList<Results>) {
        adapterProducts = AdapterProducts(activity, list, this)
        val mLayoutManager: RecyclerView.LayoutManager = GridLayoutManager(activity, 1)
        binding.fgProductsRvRegiones.layoutManager = mLayoutManager
        binding.fgProductsRvRegiones.setHasFixedSize(true)
        binding.fgProductsRvRegiones.adapter = adapterProducts
        binding.fgProductsRvRegiones.visibility = View.VISIBLE
        binding.tvTitle.text = args.tittle
    }

    override fun listenerButtonOnClick(objectResult: Results) {
        findNavController().navigate(ProductsFragmentDirections.actionProductsFragmentToDetailsProductFragment(objectResult))
    }

    private fun listeners(){
        binding.imgBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}

