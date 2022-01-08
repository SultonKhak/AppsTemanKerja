package com.temankerja.temankerja.ui.user.informasi

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.temankerja.temankerja.R
import com.temankerja.temankerja.databinding.ListHomeBinding
import com.temankerja.temankerja.databinding.ListInformasiBinding
import com.temankerja.temankerja.models.Information
import com.temankerja.temankerja.models.Jobs
import com.temankerja.temankerja.models.JobsApplicants
import com.temankerja.temankerja.models.Sertifikasi
import com.temankerja.temankerja.ui.applicants.ApplicantsAdapter
import com.temankerja.temankerja.ui.user.sertifikasi.SertifikasiAdapter

class InformasiAdapter() : RecyclerView.Adapter<InformasiAdapter.ListViewHolder>() {
    inner class ListViewHolder (val binding: ListInformasiBinding) : RecyclerView.ViewHolder(binding.root)

    private var informationData = mutableListOf<Information>()
    private var setOnItemClickCallback : InformasiAdapter.OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: InformasiAdapter.OnItemClickCallback) {
        this.setOnItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            ListInformasiBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun setInformationData(list: List<Information>){
        informationData.clear()
        informationData = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val info = informationData[position]
        holder.binding.informasiTitle.text = info.title
        holder.binding.informasiDesc.text = info.desc
        Glide.with(holder.itemView.context)
            .load(info.img)
            .into(holder.binding.informasiImg)

        holder.binding.root.setOnClickListener {
            setOnItemClickCallback?.onItemClicked(info)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Information)
    }

    override fun getItemCount(): Int {
        return informationData.size
    }
}