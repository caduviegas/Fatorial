package com.innaval.fatorial;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;



public class MainViewModel extends ViewModel {

    private UseCase useCase = new UseCase();
    private MutableLiveData<Double> factorial = new MutableLiveData<>();


    public LiveData<Double> getFatorial() {
        return factorial;
    }

    public void onClickButtonCalcFatorial(double num) {
        Double reposta = useCase.useCaseCalcFatorial(num);
        factorial.postValue(reposta);
    }
}
