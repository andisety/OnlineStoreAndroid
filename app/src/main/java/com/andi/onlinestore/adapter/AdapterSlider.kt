package com.andi.onlinestore.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.andi.onlinestore.R

class AdapterSlider(val listData:ArrayList<Int>, val context: Activity?):PagerAdapter() {
    lateinit var layoutInflater: LayoutInflater
    override fun getCount(): Int {
        return listData.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view==`object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        layoutInflater= LayoutInflater.from(context)
        val view:View=layoutInflater.inflate(R.layout.slider_item,container,false)

        //Init
        val imageView: ImageView
        imageView = view.findViewById(R.id.img_slider)

        imageView.setImageResource(listData[position])
        container.addView(view, 0)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}