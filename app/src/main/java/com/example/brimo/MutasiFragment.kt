package com.example.brimo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.brimo.adapter.FragmentPageMutasiAdapter

import com.example.brimo.databinding.FragmentMutasiBinding

import com.google.android.material.tabs.TabLayout

class MutasiFragment : Fragment() {

    private var _binding : FragmentMutasiBinding? = null
    private val binding get() = _binding!!
    private lateinit var adaptor : FragmentPageMutasiAdapter
    private lateinit var titleList : Array<String>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMutasiBinding.inflate(inflater,container, false)
        val view = binding.root
        // Inflate the layout for this fragment
        return view

        titleList = arrayOf(
            "Satu",
            "Dua",
            "Tiga",
            "Empat",
            "Lima",
            "Enam",
            "Tujuh",
            "Delapan",
            "Sembilan"
        )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adaptor = FragmentPageMutasiAdapter(requireActivity().supportFragmentManager,lifecycle)

        val tl = binding.tabLayoutMutasi
        val vp = binding.viewPagerMutasi

//        tl.setSelectedTabIndicator(R.drawable.tab_indicator)

        tl.addTab(tl.newTab().setText("Mutasi Transaksi"))
        tl.addTab(tl.newTab().setText("e-Statement"))


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