package com.example.cuentabancaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etxtUsuario, etxtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etxtUsuario = findViewById(R.id.etxtUsuario);
        etxtPassword = findViewById(R.id.etxtPassword);
        SharedPreferences p = getSharedPreferences("Datos", Context.MODE_PRIVATE);
        etxtUsuario.setText(p.getString("Usuario", " "));
        etxtPassword.setText(p.getString("Password", " "));
    }

    public void crearCuenta (View view){
        SharedPreferences p = getSharedPreferences("Datos", Context.MODE_PRIVATE);
        String usuario = etxtUsuario.getText().toString();
        String password = etxtPassword.getText().toString();
        SharedPreferences.Editor e = p.edit();
        e.putString("Usuario", etxtUsuario.getText().toString());
        e.putString("Password", etxtPassword.getText().toString());
        etxtUsuario.setText(usuario);
        etxtPassword.setText(password);
        e.commit();
        finish();
    }

    public void  ingresar (View view){
        Intent enviar = new Intent(this, Account.class);
        enviar.putExtra("Usuario", etxtUsuario.getText().toString());
        startActivity(enviar);
    }
}