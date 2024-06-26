package com.example.brimo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.brimo.R
import com.example.brimo.data.dataAktivasi
import com.example.brimo.data.dataPemasukanClass
import com.google.android.flexbox.FlexboxLayout
import de.hdodenhof.circleimageview.CircleImageView

class AdapterAktivasiClass(private val dataList: ArrayList<dataAktivasi>) : RecyclerView.Adapter<AdapterAktivasiClass.ViewHolderClass>(){

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rvImage: ImageView = itemView.findViewById(R.id.itemAktivitiasImage)
        val rvTitle: TextView = itemView.findViewById(R.id.itemAktivitiasTitle)
        val rvRek: TextView = itemView.findViewById(R.id.itemAktivitiasRek)
        val rvRef: TextView = itemView.findViewById(R.id.itemAktivitiasRef)
        val rvTanggal: TextView = itemView.findViewById(R.id.itemAktivitiasTanggal)
        val containerAktivitas: FlexboxLayout = itemView.findViewById(R.id.ContainerAktivitas)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_aktivitas, parent, false)
        return ViewHolderClass(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.rvTitle.text = currentItem.dataTitle
        holder.rvRek.text = currentItem.dataRek
        holder.rvRef.text = currentItem.dataRef
        holder.rvTanggal.text = currentItem.dataDate


        holder.containerAktivitas.startAnimation(AnimationUtils.loadAnimation(holder.itemView.context, R.anim.anim_fade_load_recycler))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}