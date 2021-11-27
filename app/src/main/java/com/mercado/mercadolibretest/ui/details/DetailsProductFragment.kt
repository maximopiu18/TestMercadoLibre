package com.mercado.mercadolibretest.ui.details

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mercado.mercadolibretest.BaseFragment
import com.mercado.mercadolibretest.R
import com.mercado.mercadolibretest.data.model.Results
import com.mercado.mercadolibretest.databinding.FragmentDetailsProductBinding
import com.squareup.picasso.Picasso

class DetailsProductFragment : BaseFragment<FragmentDetailsProductBinding>(R.layout.fragment_details_product){

    lateinit var binding: FragmentDetailsProductBinding
    val args: DetailsProductFragmentArgs by navArgs()
    lateinit var resultProduct: Results


    override fun onCreate(savedInstanceState: Bundle?) {
        getComponent().inject(this)
        super.onCreate(savedInstanceState)

    }

    override fun FragmentDetailsProductBinding.initialize() {
        binding = this
        resultProduct = args.integrantesItem
        setUpInitview()
        listeners()
    }

    @SuppressLint("SetTextI18n")
    private fun setUpInitview(){
        binding.tvTittle.text ="${resultProduct.title}"
        binding.tvAcceptMercadoPago.text = "Acepta Mercado Pago?: " + resultProduct.acceptsMercadoPago
        binding.tvId.text = "ID Producto: ${resultProduct.id}"
        binding.tvAvariableQuantity.text ="Cantidad actual: ${resultProduct.availableQuantity}"
        binding.tvAvariableSold.text = "Cantidad en venta: ${resultProduct.soldQuantity}"
        binding.tvCurrencyId.text  = "Moneda: ${resultProduct.currencyId}"
        binding.tvPrice.text ="Precio: ${resultProduct.price}"
        var url =resultProduct.thumbnail
        url = url!!.replace("http://","https://")
        Picasso
            .with(activity)
            .load(url)
            .resize(500, 500) // resizes the image to these dimensions (in pixel)
            .centerCrop()
            .into(binding.imgProducto)
    }
    private fun listeners(){
        binding.imgBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }


}