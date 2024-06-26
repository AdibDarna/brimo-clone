package com.example.brimo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.brimo.R
import com.example.brimo.data.dataMutasiTransaksiClass
import com.example.brimo.data.dataPemasukanClass
import com.google.android.flexbox.FlexboxLayout
import de.hdodenhof.circleimageview.CircleImageView

class AdapterMutasiTransaksiClass (private val dataList: ArrayList<dataMutasiTransaksiClass>) : RecyclerView.Adapter<AdapterMutasiTransaksiClass.ViewHolderClass>(){

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rvRef: TextView = itemView.findViewById(R.id.itemMutasiRef)
        val rvNominal: TextView = itemView.findViewById(R.id.itemMutasiNominal)
        val rvJam: TextView = itemView.findViewById(R.id.itemMutasiJam)
        val container:FlexboxLayout = itemView.findViewById(R.id.ContainerMutasi)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_mutasi_transaksi, parent, false)
        return ViewHolderClass(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.rvRef.text = currentItem.dataRef
        holder.rvNominal.text = currentItem.dataNominal
        holder.rvJam.text = currentItem.tanggal


        holder.container.startAnimation(AnimationUtils.loadAnimation(holder.itemView.context, R.anim.anim_fade_load_recycler))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}