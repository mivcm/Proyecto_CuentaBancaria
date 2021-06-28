package com.example.cuentabancaria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Account extends AppCompatActivity {
    private TextView txtUsuario, txtSaldo;
    private EditText etxtDeposito, etxtRetiro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        txtUsuario = findViewById(R.id.txtUsuario);
        txtSaldo = findViewById(R.id.txtSaldo);
        etxtDeposito = findViewById(R.id.etxtDeposito);
        etxtRetiro = findViewById(R.id.etxtRetiro);
        String enviar = getIntent().getStringExtra("Usuario");
        txtUsuario.setText(enviar);
    }

    public void deposito (View view){
        int saldo = Integer.parseInt(txtSaldo.getText().toString());
        int depositar = Integer.parseInt(etxtDeposito.getText().toString());
        int suma = saldo + depositar;
        String resul = String.valueOf(suma);
        txtSaldo.setText(resul);
    }

    public void retiro (View v){
        int saldo = Integer.parseInt(txtSaldo.getText().toString());
        int retirar = Integer.parseInt(etxtRetiro.getText().toString());
        int resta = saldo - retirar;
        String resul =  String.valueOf(resta);
        txtSaldo.setText(resul);
    }

    public void confirmar (View vi){
        if (etxtRetiro != null){
            retiro(null);
        } else if (etxtDeposito != null){
            deposito(null);
        }
    }
}