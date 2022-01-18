package com.temankerja.temankerja.ui.success

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.temankerja.temankerja.R
import com.temankerja.temankerja.databinding.ActivitySuccessRecruitBinding
import com.temankerja.temankerja.ui.recruiter.RecruiterActivity

class SuccessActivityRecruiter : AppCompatActivity() {
    private lateinit var binding : ActivitySuccessRecruitBinding
    companion object{
        const val EXTRA_IS_RECRUITER = "extra_is_recruiter"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuccessRecruitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val isRecruiter = intent.getBooleanExtra(EXTRA_IS_RECRUITER, false)
        if (isRecruiter) {
            binding.btnBack.setOnClickListener {
                startActivity(Intent(this, RecruiterActivity::class.java))
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            binding.btnBack.setBackgroundColor(resources.getColor(R.color.purple))
            binding.tvLabelSuccessRecruit.text = "Calon telah direkrut"
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, RecruiterActivity::class.java))
    }
}