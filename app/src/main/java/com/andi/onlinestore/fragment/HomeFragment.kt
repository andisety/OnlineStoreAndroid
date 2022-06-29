package com.andi.onlinestore.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.andi.onlinestore.R

class HomeFragment : Fragment() {

    lateinit var vpSlider:ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View=inflater.inflate(R.layout.fragment_home, container, false)
        vpSlider=view.findViewById(R.id.vp_slider)

        val arrSlider = ArrayList<Int>()
        return view
    }


}