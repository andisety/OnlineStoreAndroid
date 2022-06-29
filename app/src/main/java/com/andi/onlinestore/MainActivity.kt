package com.andi.onlinestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.andi.onlinestore.fragment.AkunFragment
import com.andi.onlinestore.fragment.HomeFragment
import com.andi.onlinestore.fragment.KeranjangFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val keranjangFragment = KeranjangFragment()
    private val akunFragment = AkunFragment()
    private val fm = supportFragmentManager
    private var active:Fragment = homeFragment

    private lateinit var menu: Menu
    private lateinit var menuItem:MenuItem
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpBottomNav()

    }

    private fun setUpBottomNav() {
        fm.beginTransaction().add(R.id.container,homeFragment).show(homeFragment).commit()
        fm.beginTransaction().add(R.id.container,akunFragment).hide(akunFragment).commit()
        fm.beginTransaction().add(R.id.container,keranjangFragment).hide(keranjangFragment).commit()

        bottomNavigationView = findViewById(R.id.nav_view)
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked=true

        bottomNavigationView.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.navigation_home->{
                    Log.e("bottomNav","home")
                    callFragment(0,homeFragment)
                }
                R.id.navigation_keranjang->{
                    Log.e("bottomNav","keranjang")
                    callFragment(1,keranjangFragment)
                }
                R.id.navigation_akun->{
                    Log.e("bottomNav","akun")
                    callFragment(2,akunFragment)
                }
            }

            false
        }
    }


    private fun callFragment(index:Int,fragment:Fragment){
        menuItem = menu.getItem(index)
        menuItem.isChecked=true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active=fragment
    }
}