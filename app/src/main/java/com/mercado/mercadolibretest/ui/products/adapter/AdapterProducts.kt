package com.mercado.mercadolibretest.ui.products.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mercado.mercadolibretest.R
import com.mercado.mercadolibretest.data.model.Results
import com.squareup.picasso.Picasso
import java.util.*

    class AdapterProducts(private var context : Context, private var listResultsProducts: ArrayList<Results>, private  var listener: AdapterListener)
        : RecyclerView.Adapter<AdapterProducts.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val listItem = layoutInflater.inflate(R.layout.item_products, parent, false)
            return ViewHolder(listItem)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            var url =listResultsProducts[position].thumbnail!!
            url = url.replace("http://","https://")
            Picasso
                .with(context)
                .load(url)
                .resize(500, 500)
                .centerCrop()
                .into(holder.imgProduct)
            holder.tvTittle.text = listResultsProducts[position].title
            holder.layoutItem.setOnClickListener {
                listener.listenerButtonOnClick(listResultsProducts[position])
            }
        }

        override fun getItemCount(): Int {
            return listResultsProducts.size
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var imgProduct: ImageView = itemView.findViewById<View>(R.id.item_img_produto) as ImageView
            var tvTittle : TextView = itemView.findViewById<View>(R.id.item_tv_tittle) as TextView
            var layoutItem: LinearLayout = itemView.findViewById<View>(R.id.item_layout_main) as LinearLayout

        }

         interface AdapterListener {
            fun listenerButtonOnClick(objectResult:Results)
        }
    }