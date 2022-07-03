package com.andi.onlinestore.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.andi.onlinestore.R
import com.andi.onlinestore.adapter.AdapterProduk
import com.andi.onlinestore.adapter.AdapterSlider
import com.andi.onlinestore.model.Produk

class HomeFragment : Fragment() {

    lateinit var vpSlider:ViewPager
    lateinit var rvProduk:RecyclerView
    lateinit var rvProdukLaris:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View=inflater.inflate(R.layout.fragment_home, container, false)
        vpSlider=view.findViewById(R.id.vp_slider)
        rvProduk=view.findViewById(R.id.rv_produk)
        rvProdukLaris=view.findViewById(R.id.rv_produk_terlaris)

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation=LinearLayoutManager.HORIZONTAL
        //produk baru
        rvProduk.adapter=AdapterProduk(arrProduk)
        rvProduk.layoutManager = layoutManager

        val layoutManager2 = LinearLayoutManager(activity)
        layoutManager2.orientation=LinearLayoutManager.HORIZONTAL
        //produk laris
        rvProdukLaris.adapter=AdapterProduk(arrProduk)
        rvProdukLaris.layoutManager = layoutManager2



        val arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.s1)
        arrSlider.add(R.drawable.s2)
        arrSlider.add(R.drawable.s3)
        val adapterSlider = AdapterSlider(arrSlider,activity)
        vpSlider.adapter=adapterSlider
        return view
    }

    val arrProduk:ArrayList<Produk>get(){
        val arr = ArrayList<Produk>()
        val p1=Produk()
        p1.nama="Hp core i3"
        p1.harga="Rp.5.000.000"
        p1.gambar=R.drawable.s1

        val p2=Produk()
        p2.nama="Hp core i3"
        p2.harga="Rp.5.000.000"
        p2.gambar=R.drawable.s2

        val p3=Produk()
        p3.nama="Hp core i3"
        p3.harga="Rp.5.000.000"
        p3.gambar=R.drawable.s3
        arr.add(p1)
        arr.add(p2)
        arr.add(p3)
        return arr
    }


}