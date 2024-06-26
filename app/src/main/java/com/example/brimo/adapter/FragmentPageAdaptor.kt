package com.example.brimo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.brimo.LaporanFragment
import com.example.brimo.PemasukanFragment
import com.example.brimo.PengeluaranFragment

class fragmentPageAdaptor (fragmentManager : FragmentManager,
                           lifecycle : Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0)
            PengeluaranFragment()
        else if (position == 1)
            PemasukanFragment()
        else
            LaporanFragment()

    }
}