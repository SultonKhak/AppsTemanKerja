package com.temankerja.temankerja.ui.user.sertifikasi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.temankerja.temankerja.models.Sertifikasi
import com.temankerja.temankerja.databinding.ListSertifikasiBinding
import com.temankerja.temankerja.models.Jobs
import com.temankerja.temankerja.ui.user.home.HomeAdapter

class SertifikasiAdapter() : RecyclerView.Adapter<SertifikasiAdapter.ListViewHolder>() {
    inner class ListViewHolder (val binding: ListSertifikasiBinding) : RecyclerView.ViewHolder(binding.root)

    private var sertifikasiData = mutableListOf<Sertifikasi>()
    private var setOnItemClickCallback : OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.setOnItemClickCallback = onItemClickCallback
    }

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
        holder.binding.root.setOnClickListener {
            setOnItemClickCallback?.onItemClicked(info)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Sertifikasi)
    }

    override fun getItemCount(): Int {
        return sertifikasiData.size
    }
}