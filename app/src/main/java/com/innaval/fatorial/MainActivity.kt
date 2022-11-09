package com.innaval.fatorial

import androidx.appcompat.app.AppCompatActivity
import com.innaval.fatorial.MainViewModel
import android.animation.ValueAnimator
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import android.view.animation.BounceInterpolator
import android.animation.ValueAnimator.AnimatorUpdateListener
import android.view.View
import com.innaval.fatorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var viewModel: MainViewModel? = null
    private var binding: ActivityMainBinding? = null
    private var valueAnimator: ValueAnimator? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        bindViewModel()
        setupObservers()
        setupListerners()
    }

    private fun bindViewModel() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private fun setupObservers() {
        viewModel!!.fatorial.observe(this) { resposta: Double? ->
            binding!!.tvResposta.text = resposta.toString()!!

        }
    }

    private fun setupListerners() {
        binding!!.btnCalcular.setOnClickListener { v: View? ->
            val numero = binding!!.etCalculofatorial.text.toString()
            val numeroInicial = numero.toDouble()
            viewModel!!.onClickButtonCalcFatorial(numeroInicial)
           // animatorAnswer()
           // valueAnimator!!.start()
        }
    }

    /*private fun animatorAnswer() {
        val valueAnimator = ValueAnimator.ofInt(0, 20, -20, 18, -18, 15, -15, 6, -6, 0)
        val duration = valueAnimator.setDuration(2000)
        valueAnimator.setInterpolator(BounceInterpolator())
        valueAnimator.addUpdateListener { animation ->
            val value = animation.animatedValue as Int
            binding!!.btnCalcular.translationX = value.toFloat()
            binding!!.btnCalcular.minWidth = value * 25
        }
    }*/
}