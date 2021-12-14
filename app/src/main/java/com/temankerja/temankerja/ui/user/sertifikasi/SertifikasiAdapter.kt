package com.temankerja.temankerja.ui.user.sertifikasi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.temankerja.temankerja.models.Sertifikasi
import com.temankerja.temankerja.databinding.ListSertifikasiBinding

class SertifikasiAdapter() : RecyclerView.Adapter<SertifikasiAdapter.ListViewHolder>() {
    inner class ListViewHolder (val binding: ListSertifikasiBinding) : RecyclerView.ViewHolder(binding.root)

    private var sertifikasiData = mutableListOf<Sertifikasi>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SertifikasiAdapter.ListViewHolder {
        return ListViewHolder(
            ListSertifikasiBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun setSertifikasiData(list: List<Sertifikasi>){
        sertifikasiData.clear()
        sertifikasiData = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: SertifikasiAdapter.ListViewHolder, position: Int) {
        val info = sertifikasiData[position]
        holder.binding.sertifikasiTitle.text = info.title
        holder.binding.sertifikasiDesc.text = info.deskripsi
        Glide.with(holder.itemView.context)
            .load(info.img)
            .into(holder.binding.sertifikasiImg)
    }

    override fun getItemCount(): Int {
        return sertifikasiData.size
    }
}