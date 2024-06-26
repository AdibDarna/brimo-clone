package com.example.brimo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.brimo.adapter.AdapterMutasiTransaksiClass
import com.example.brimo.adapter.AdapterPemasukanClass
import com.example.brimo.data.dataMutasiTransaksiClass
import com.example.brimo.data.dataPemasukanClass
import com.example.brimo.databinding.FragmentMutasiTransaksiBinding
import com.example.brimo.databinding.FragmentPemasukanBinding


class MutasiTransaksiFragment : Fragment() {

    private var _binding: FragmentMutasiTransaksiBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList : ArrayList<dataMutasiTransaksiClass>
    lateinit var titleList:Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMutasiTransaksiBinding.inflate(inflater,container, false)
        val view = binding.root

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

        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.recyclerViewMutasiTransaksi
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<dataMutasiTransaksiClass>()
        getData()
    }

    private fun getData() {
        for(i in titleList.indices){
            val dataClass = dataMutasiTransaksiClass(titleList[i], titleList[i], titleList[i], titleList[i])
            dataList.add(dataClass)

        }
        recyclerView.adapter = AdapterMutasiTransaksiClass(dataList)
    }


}