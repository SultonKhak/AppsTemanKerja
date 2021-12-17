package com.temankerja.temankerja.ui.user.sertifikasi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.temankerja.temankerja.databinding.FragmentSertifikasiBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.temankerja.temankerja.models.Jobs
import com.temankerja.temankerja.models.Sertifikasi
import com.temankerja.temankerja.ui.user.detail.DetailActivity
import com.temankerja.temankerja.ui.user.home.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SertifikasiFragment : Fragment() {

    private var _binding : FragmentSertifikasiBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy { SertifikasiAdapter() }
    private val viewModel: SertifikasiViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSertifikasiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRv()
        activity?.let {
            viewModel.data.observe(it, {
                it.data?.let { data -> adapter.setSertifikasiData(data) }
            })
        }
        adapter.setOnItemClickCallback(object : SertifikasiAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Sertifikasi) {
                val intent = Intent(Intent.ACTION_VIEW).setData(Uri.parse(data.link));
                startActivity(intent)
                Log.e("TAG", "Link: $data.link", )
            }
        })
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupRv() {
        binding.rvSertifikasi.adapter = adapter
        binding.rvSertifikasi.layoutManager = LinearLayoutManager(context)
        binding.rvSertifikasi.setHasFixedSize(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}