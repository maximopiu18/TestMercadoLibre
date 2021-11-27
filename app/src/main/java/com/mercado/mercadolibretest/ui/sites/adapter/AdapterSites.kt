package com.mercado.mercadolibretest.ui.sites.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.mercado.mercadolibretest.R
import com.mercado.mercadolibretest.data.model.Sites
import java.util.*

class AdapterSites(private var listSites: ArrayList<Sites>, private  var listener: AdapterListener) : RecyclerView.Adapter<AdapterSites.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.item_sites, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.btnSite.text = listSites[position].name
        holder.btnSite.setOnClickListener {
            listener.listenerButtonOnClick(listSites[position].id.toString())
        }
    }

    override fun getItemCount(): Int {
        return listSites.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var btnSite: Button = itemView.findViewById<View>(R.id.item_btn_site) as Button

    }

     interface AdapterListener {
        fun listenerButtonOnClick(id:String)
    }
}