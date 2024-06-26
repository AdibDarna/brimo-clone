package com.example.brimo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.brimo.adapter.AdapterPemasukanClass
import com.example.brimo.adapter.AdapterPengeluaranClass
import com.example.brimo.data.dataPemasukanClass
import com.example.brimo.data.dataPengeluaranClass
import com.example.brimo.databinding.FragmentPemasukanBinding
import com.example.brimo.databinding.FragmentPengeluaranBinding


class PemasukanFragment : Fragment() {

    private var _binding: FragmentPemasukanBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList : ArrayList<dataPemasukanClass>
    lateinit var titleList:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPemasukanBinding.inflate(inflater,container, false)
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

        recyclerView = binding.recyclerViewPemasukan
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<dataPemasukanClass>()
        getData()




    }

    private fun getData() {
        for(i in titleList.indices){
            val dataClass = dataPemasukanClass(i+1, titleList[i], titleList[i], titleList[i], titleList[i], titleList[i])
            dataList.add(dataClass)

        }
        recyclerView.adapter = AdapterPemasukanClass(dataList)
    }


}