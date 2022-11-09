package com.innaval.fatorial

class UseCase {
    fun useCaseCalcFatorial(num: Double): Double {
        return if (num < 2) {
            1.0
        } else {
            num * useCaseCalcFatorial(num - 1)
        }
    }
}