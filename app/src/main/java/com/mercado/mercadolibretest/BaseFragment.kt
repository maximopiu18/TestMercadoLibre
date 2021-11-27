package com.mercado.mercadolibretest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.mercado.mercadolibretest.ui.MainActivity

open class BaseFragment<T : ViewDataBinding>(@LayoutRes private val layoutResId: Int) : Fragment() {


    private var _binding: T? = null

    private val binding: T get() = _binding!!

    val activity: AppCompatActivity by lazy {
        requireActivity() as MainActivity
    }


    open fun T.initialize() {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        binding.initialize()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        _binding = null
        super.onResume()
    }


    protected fun getComponent() = (requireActivity().applicationContext as ApplicationMercado).appComponent
}



