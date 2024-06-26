package com.example.brimo

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.brimo.databinding.FragmentHomeBinding
import com.google.android.flexbox.FlexboxLayout
import java.util.zip.Inflater


class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var btnShowSaldo : ImageView
    private lateinit var imgDotSaldo : ImageView
    private lateinit var txtSaldo : TextView

    private var statusSaldo : Boolean = true

    private lateinit var btn_detail : FlexboxLayout

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentHomeBinding.inflate(inflater, container,false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_detail = binding.btnCatatanDetail
        btnShowSaldo = binding.btnShowSaldo
        imgDotSaldo = binding.imgDot
        txtSaldo = binding.txtSaldo

        btnShowSaldo.setOnClickListener {
            if (statusSaldo == true){
                imgDotSaldo.visibility = View.VISIBLE
                txtSaldo.visibility = View.GONE
                statusSaldo = false
            }else{
                imgDotSaldo.visibility = View.GONE
                txtSaldo.visibility = View.VISIBLE
                statusSaldo = true

            }

        }


        btn_detail.setOnClickListener {
            val intent = Intent(it.context, CatatanPengeluaranActivity::class.java)
            startActivity(intent)
        }

    }


}