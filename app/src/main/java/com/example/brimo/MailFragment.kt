package com.example.brimo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.brimo.adapter.AdapterAktivasiClass
import com.example.brimo.adapter.AdapterPemasukanClass
import com.example.brimo.data.dataAktivasi
import com.example.brimo.data.dataPemasukanClass
import com.example.brimo.databinding.FragmentMailBinding
import com.example.brimo.databinding.FragmentMutasiBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MailFragment : Fragment() {
    private var _binding : FragmentMailBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList : ArrayList<dataAktivasi>
    lateinit var titleList:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentMailBinding.inflate(inflater,container, false)
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


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerViewAktivitas
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<dataAktivasi>()
        getData()

    }

    private fun getData() {
        for(i in titleList.indices){
            val dataClass = dataAktivasi(i+1, titleList[i], titleList[i], titleList[i], titleList[i])
            dataList.add(dataClass)

        }
        recyclerView.adapter = AdapterAktivasiClass(dataList)
    }


}