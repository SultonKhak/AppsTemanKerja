package com.temankerja.temankerja.ui.user.sertifikasi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.temankerja.temankerja.data.DataOrException
import com.temankerja.temankerja.models.Sertifikasi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class SertifikasiViewModel @Inject constructor(
    private val repository: SertifikasiRepository
) : ViewModel() {
    val data = MutableLiveData<DataOrException<List<Sertifikasi>, Exception>>()

    init {
        getSertifikasi()
    }

    private fun getSertifikasi() {
        viewModelScope.launch {
            data.postValue(repository.getSertifikasi())
        }
    }
}