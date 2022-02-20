package com.temankerja.temankerja.ui.user.informasi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.temankerja.temankerja.databinding.FragmentInformasiBinding
import com.temankerja.temankerja.models.Information
import com.temankerja.temankerja.models.Jobs
import com.temankerja.temankerja.ui.user.detail.DetailActivity
import com.temankerja.temankerja.ui.user.home.HomeAdapter
import com.temankerja.temankerja.ui.user.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InformasiFragment : Fragment() {

    private var _binding : FragmentInformasiBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy { InformasiAdapter() }
    private val viewModel: InformasiViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInformasiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRv()
        activity?.let {
            viewModel.data.observe(it) {
                it.data?.let { data -> adapter.setInformationData(data) }
            }
        }
        adapter.setOnItemClickCallback(object : InformasiAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Information) {
                selectedData(data)
            }
        })
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupRv() {
        binding.rvInformation.adapter = adapter
        binding.rvInformation.layoutManager = LinearLayoutManager(context)
        binding.rvInformation.setHasFixedSize(true)
    }

    private fun selectedData(data: Information) {
        Intent(requireActivity(), DetailInformasiActivity::class.java).apply {
            putExtra(DetailInformasiActivity.EXTRA_INFO, data)
            startActivity(this)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}