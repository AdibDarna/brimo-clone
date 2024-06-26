package com.example.brimo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.brimo.R
import com.example.brimo.data.dataPemasukanClass
import com.example.brimo.data.dataPengeluaranClass
import com.google.android.flexbox.FlexboxLayout
import de.hdodenhof.circleimageview.CircleImageView

class AdapterPemasukanClass (private val dataList: ArrayList<dataPemasukanClass>) : RecyclerView.Adapter<AdapterPemasukanClass.ViewHolderClass>(){

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rvImage: CircleImageView = itemView.findViewById(R.id.itemImage)
        val rvTitle: TextView = itemView.findViewById(R.id.itemTitle)
        val rvDari: TextView = itemView.findViewById(R.id.itemFrom)
        val rvUntuk: TextView = itemView.findViewById(R.id.itemTo)
        val rvNominal: TextView = itemView.findViewById(R.id.itemNominal)
        val rvTanggal: TextView = itemView.findViewById(R.id.itemDate)
        val rvTotal: TextView = itemView.findViewById(R.id.itemTotal)
        val container:FlexboxLayout = itemView.findViewById(R.id.Contianer)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_pengeluaran_pemasukan, parent, false)
        return ViewHolderClass(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.rvTitle.text = currentItem.dataTitle
        holder.rvDari.text = currentItem.dataDari
        holder.rvUntuk.text = currentItem.dataUntuk
        holder.rvNominal.text = currentItem.dataNominal
        holder.rvTanggal.text = currentItem.dataTanggal
        holder.rvTotal.text = currentItem.dataNominal

        holder.container.startAnimation(AnimationUtils.loadAnimation(holder.itemView.context, R.anim.anim_fade_load_recycler))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}