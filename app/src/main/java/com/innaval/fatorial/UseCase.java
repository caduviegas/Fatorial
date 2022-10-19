package com.innaval.fatorial;

public class UseCase {

    public Double useCaseCalcFatorial(double num){

        if (num < 2) {
            return 1.0;
        } else {
            return num * useCaseCalcFatorial(num - 1);
        }
    }
}
