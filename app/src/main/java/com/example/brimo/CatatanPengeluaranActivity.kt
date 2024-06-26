package com.example.brimo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.brimo.adapter.fragmentPageAdaptor
import com.example.brimo.databinding.ActivityCatatanPengeluaranBinding
import com.google.android.material.tabs.TabLayout

class CatatanPengeluaranActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCatatanPengeluaranBinding
    private lateinit var adaptor: fragmentPageAdaptor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatatanPengeluaranBinding.inflate(layoutInflater)

        setContentView(binding.root)

        adaptor = fragmentPageAdaptor(supportFragmentManager,lifecycle)

        val tl = binding.tabLayout1
        val vp = binding.viewPager

//        tl.setSelectedTabIndicator(R.drawable.tab_indicator)

        tl.addTab(tl.newTab().setText("Pengeluaran"))
        tl.addTab(tl.newTab().setText("Pemasukan"))
        tl.addTab(tl.newTab().setText("Laporan"))

        vp.adapter = adaptor

        tl.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null){
                    vp.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }


        })

        vp.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tl.selectTab(tl.getTabAt(position))
            }
        })
    }
}