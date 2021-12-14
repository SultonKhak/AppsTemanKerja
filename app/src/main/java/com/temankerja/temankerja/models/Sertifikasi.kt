package com.temankerja.temankerja.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sertifikasi(
    val title: String = "",
    val deskripsi: String = "",
    val img: String? = "",
) : Parcelable