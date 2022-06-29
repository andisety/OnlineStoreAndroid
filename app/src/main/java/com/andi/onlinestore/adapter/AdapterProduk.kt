package com.andi.onlinestore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andi.onlinestore.R
import com.andi.onlinestore.model.Produk

class AdapterProduk(val data:ArrayList<Produk>):RecyclerView.Adapter<AdapterProduk.ProdukViewHolder>() {
    class ProdukViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var image = itemView.findViewById<ImageView>(R.id.img_produk)
        var nama = itemView.findViewById<TextView>(R.id.nama_produk)
        var harga = itemView.findViewById<TextView>(R.id.harga_produk)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdukViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_produk,parent,false)
        return ProdukViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdukViewHolder, position: Int) {
        val produk = data[position]
        holder.nama.text=produk.nama
        holder.harga.text=produk.harga
        holder.image.setImageResource(produk.gambar)

    }

    override fun getItemCount(): Int {
        return data.size
    }
}