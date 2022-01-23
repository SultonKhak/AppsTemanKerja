package com.temankerja.temankerja.ui.detailapplicant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.temankerja.temankerja.R
import com.temankerja.temankerja.databinding.ActivityDetailApplicantBinding
import com.temankerja.temankerja.models.JobsApplicants
import com.temankerja.temankerja.ui.success.SuccessActivityRecruiter
import com.temankerja.temankerja.utils.StatusBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailApplicantActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityDetailApplicantBinding
    private lateinit var id: String
    private val viewModel : DetailApplicantViewModel by viewModels()
    companion object {
        const val EXTRA_FULLNAME = "extra_fullname"
        const val EXTRA_LOC = "extra_loc"
        const val EXTRA_NOKTP = "extra_noktp"
        const val EXTRA_NOTELP = "extra_notelp"
        const val EXTRA_SKILLS = "extra_skills"
        const val EXTRA_GENDER = "extra_gender"
        const val EXTRA_RESUME = "extra_resume"
        const val EXTRA_APPLICANT_ID = "extra_applicant_id"
        const val EXTRA_PHOTO = "extra_photo"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailApplicantBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fullname = intent.getStringExtra(EXTRA_FULLNAME)
        val gender = intent.getStringExtra(EXTRA_GENDER)
        val resume = intent.getStringExtra(EXTRA_RESUME)
        val photo = intent.getStringExtra(EXTRA_PHOTO)
        val skills = intent.getStringExtra(EXTRA_SKILLS)
        val notelp = intent.getStringExtra(EXTRA_NOTELP)
        val noktp = intent.getStringExtra(EXTRA_NOKTP)
        val loc = intent.getStringExtra(EXTRA_LOC)
        id = intent.getStringExtra(EXTRA_APPLICANT_ID).toString()
        setSupportActionBar(findViewById(R.id.toolbar2))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        binding.userInclude.tvNavTitle.text = "Detail Pelamar"
        StatusBar.changeColor(window, this)
        binding.apply {
            tvNoKtp.text = noktp
            tvNoTelp.text = notelp
            tvKeterampilan.text = skills
            tvFullName.text = fullname
            tvLoc.text = loc
            tvGender.text = "${gender}"
            tvResume.text = resume
            if(photo!=""){
                Glide.with(this@DetailApplicantActivity)
                    .load(photo)
                    .into(imgApplicantProfile)
            }
        }
        binding.btnApplyRekrut.setOnClickListener(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_apply_rekrut -> {
                viewModel.doRecruit(id)
                viewModel.data.observe(this, {
                    if(it.data != null) {
                        Intent(this, SuccessActivityRecruiter::class.java).apply {
                            putExtra(SuccessActivityRecruiter.EXTRA_IS_RECRUITER, true)
                            startActivity(this)
                        }
                        finish()
                    }
                })
            }
        }
    }
}