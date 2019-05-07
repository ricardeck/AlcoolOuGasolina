package com.example.alcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private double valorSeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = findViewById(R.id.seekBar2);
        final TextView tvSeek = findViewById(R.id.tvSeek);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSeek.setText("Rendimento alcool: " + seekBar.getProgress() + "%");
                valorSeek = seekBar.getProgress()/100.0;
            }




            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular(View view){
        TextView textViewResultado = findViewById(R.id.tvResultado);
        TextView textViewRelacao = findViewById(R.id.tvRelacao);
        TextView textViewAlcool = findViewById(R.id.etAlcool);
        TextView textViewGasolina = findViewById(R.id.etGasolina);

        if (textViewAlcool.getText().toString().isEmpty() || textViewGasolina.getText().toString().isEmpty()) {
            textViewResultado.setText("Favor informar os valores");
            return;
        }

        double relacao = Double.parseDouble(textViewAlcool.getText().toString()) / Double.parseDouble(textViewGasolina.getText().toString());

        if(relacao <= valorSeek)
            textViewResultado.setText("ABASTEÇA COM ALCOOL");
        else
            textViewResultado.setText("ABASTEÇA COM GASOLINA");

        textViewRelacao.setText("Consumo alcool: " + String.format("%.2f", relacao*100) + "%");

    }

}
