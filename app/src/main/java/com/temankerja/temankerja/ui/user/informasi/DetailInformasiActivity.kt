package com.temankerja.temankerja.ui.user.informasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.temankerja.temankerja.R
import com.temankerja.temankerja.databinding.ActivityDetailInformasiBinding
import com.temankerja.temankerja.models.Information
import com.temankerja.temankerja.models.Jobs
import com.temankerja.temankerja.ui.user.UserActivity
import com.temankerja.temankerja.ui.user.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailInformasiActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_INFO = "EXTRA_INFO"
    }
    private lateinit var binding: ActivityDetailInformasiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailInformasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val info = intent.getParcelableExtra<Information>(EXTRA_INFO) as Information
        setSupportActionBar(findViewById(R.id.toolbar2))
        super.onCreate(savedInstanceState)
        binding.apply {
            userInclude.tvNavTitle.text = "Detail Informasi"
            if(info.img!=""){
                Glide.with(this@DetailInformasiActivity)
                    .load(info.img)
                    .into(imgInfo)
            }
            titleInfo.text = info.title
            descInfo.text = info.desc
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}