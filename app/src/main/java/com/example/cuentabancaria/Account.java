package com.example.cuentabancaria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    public void retiro (View v){
        int retirar = Integer.parseInt(etxtRetiro.getText().toString());
        int saldo = Integer.parseInt(txtSaldo.getText().toString());
        int resta = saldo - retirar;
        String resul =  String.valueOf(resta);
        if (retirar > saldo){
            Toast.makeText(this, "No hay saldo suficiente", Toast.LENGTH_SHORT).show();
        } else {
            txtSaldo.setText(resul);
        }
    }

    public void deposito (View view){
        int depositar = Integer.parseInt(etxtDeposito.getText().toString());
        int saldo = Integer.parseInt(txtSaldo.getText().toString());
        int suma = saldo + depositar;
        String resul = String.valueOf(suma);
        txtSaldo.setText(resul);
    }

    public void salir (View vi) {
        finishAffinity();
    }
}