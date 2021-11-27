package com.mercado.mercadolibretest.ui.sites

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mercado.mercadolibretest.ApplicationMercado
import com.mercado.mercadolibretest.BaseFragment
import com.mercado.mercadolibretest.R
import com.mercado.mercadolibretest.data.model.Sites
import com.mercado.mercadolibretest.data.repository.SitesRepository
import com.mercado.mercadolibretest.databinding.FragmentSitesBinding
import com.mercado.mercadolibretest.ui.sites.adapter.AdapterSites
import com.mercado.mercadolibretest.ui.sites.factory.SitesViewModelFactory
import com.mercado.mercadolibretest.ui.sites.viewmodel.SitesViewModel


class SitesFragment : BaseFragment<FragmentSitesBinding>(R.layout.fragment_sites), SitesViewModel.SitesData, AdapterSites.AdapterListener {

    private var retrofit = ApplicationMercado.getRetrofitMercadoService()
    private lateinit var binding: FragmentSitesBinding
    private lateinit var sitesViewModel: SitesViewModel
    private var adapterSites: AdapterSites? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        (requireActivity().applicationContext as ApplicationMercado).appComponent.inject(this)
        super.onCreate(savedInstanceState)

    }

    override fun FragmentSitesBinding.initialize(){
        binding = this
        setUpViewModel()
        setUpObserverSites()
    }


    private fun setUpViewModel() {
        sitesViewModel = ViewModelProvider(this,
            SitesViewModelFactory(SitesRepository(retrofit),
                this)).get(SitesViewModel::class.java)
    }

    private fun setUpObserverSites() {
        sitesViewModel.getSites()
    }

    override fun onSuccess(list: ArrayList<Sites>) {
        uploadRvData(list)
    }

    override fun onError(messageError: String) {
        Log.e("error", "error: $messageError")
    }

    override fun listenerButtonOnClick(id: String) {
        findNavController().navigate(SitesFragmentDirections.actionSitesFragmentToCategoriesFragment(id))
    }

    private fun uploadRvData(list: ArrayList<Sites>) {
        adapterSites = AdapterSites(list, this)
        val mLayoutManager: RecyclerView.LayoutManager = GridLayoutManager(activity, 2)
        binding.fgSitesRvRegiones.layoutManager = mLayoutManager
        binding.fgSitesRvRegiones.setHasFixedSize(true)
        binding.fgSitesRvRegiones.adapter = adapterSites
        binding.fgSitesRvRegiones.visibility = View.VISIBLE
    }

}