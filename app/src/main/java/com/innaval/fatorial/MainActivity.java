package com.innaval.fatorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.innaval.fatorial.databinding.ActivityMainBinding;

import java.math.BigInteger;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private MainViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bindViewModel();
        setupObservers();
        setupListerners();
    }

    private void bindViewModel() {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    private void setupObservers() {
        viewModel.getFatorial().observe(this, resposta -> {
            binding.tvResposta.setText(Double.toString(resposta));
        });
    }

    private void setupListerners() {
        binding.btnCalcular.setOnClickListener(v -> {
            String numero = binding.etCalculofatorial.getText().toString();
            Double numeroInicial = Double.parseDouble(numero);
            viewModel.onClickButtonCalcFatorial(numeroInicial);
        });
    }
}

