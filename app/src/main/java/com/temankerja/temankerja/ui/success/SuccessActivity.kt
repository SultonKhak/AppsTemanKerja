package com.temankerja.temankerja.ui.success

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.temankerja.temankerja.R
import com.temankerja.temankerja.databinding.ActivitySuccessBinding
import com.temankerja.temankerja.ui.user.UserActivity

class SuccessActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySuccessBinding
    companion object{
        const val EXTRA_IS_APPLY = "extra_is_apply"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val isApply = intent.getBooleanExtra(EXTRA_IS_APPLY, false)
        if (!isApply) {
            binding.btnBackLamar.setOnClickListener {
                startActivity(Intent(this, UserActivity::class.java))
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            binding.btnBackLamar.setBackgroundColor(resources.getColor(R.color.blue))
            binding.tvLabelSuccess.text = "Lamaran Berhasil Dikirim"
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, UserActivity::class.java))
    }
}