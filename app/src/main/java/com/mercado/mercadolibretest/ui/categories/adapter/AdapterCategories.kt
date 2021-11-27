package com.mercado.mercadolibretest.ui.categories.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.mercado.mercadolibretest.R
import com.mercado.mercadolibretest.data.model.Categories
import java.util.*

class AdapterCategories(private var listCategories: ArrayList<Categories>, private  var listener: AdapterListener)
    : RecyclerView.Adapter<AdapterCategories.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.item_categories, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.btnSite.text = listCategories[position].name
        holder.btnSite.setOnClickListener {
            listener.listenerButtonOnClick(listCategories.get(position).id.toString(), listCategories[position].name.toString())
        }
    }

    override fun getItemCount(): Int {
        return listCategories.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var btnSite: Button = itemView.findViewById<View>(R.id.item_btn_site) as Button

    }

     interface AdapterListener {
        fun listenerButtonOnClick(idCategory:String, tittle: String)
    }
}