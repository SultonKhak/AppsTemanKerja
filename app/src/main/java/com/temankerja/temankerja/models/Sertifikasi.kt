package com.temankerja.temankerja.models

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Parcelize
@Keep
data class Sertifikasi(
    val title: String? = "",
    val deskripsi: String? = "",
    val img: String? = "",
    val link: String?= ""
) : Parcelable