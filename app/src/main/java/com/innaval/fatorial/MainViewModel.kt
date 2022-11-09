package com.innaval.fatorial

import androidx.lifecycle.ViewModel
import com.innaval.fatorial.UseCase
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData

class MainViewModel : ViewModel() {
    private val useCase = UseCase()
    private val factorial = MutableLiveData<Double>()
    val fatorial: LiveData<Double>
        get() = factorial

    fun onClickButtonCalcFatorial(num: Double) {
        val reposta = useCase.useCaseCalcFatorial(num)
        factorial.postValue(reposta)
    }
}