package com.example.preferencias01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button cargar, guardar;
    EditText nombre, apellidos, edad;
    String nombreS, apellidosS, edadS;
    TextView preferencias;
    SharedPreferences misPreferencias;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        misPreferencias = getSharedPreferences("prefs", MODE_PRIVATE);
        editor = misPreferencias.edit();
        cargar = findViewById(R.id.buttonCargar);
        guardar = findViewById(R.id.buttonGuardar);
        nombre = findViewById(R.id.editTextTextNombre);
        apellidos = findViewById(R.id.editTextTextApellidos);
        edad = findViewById(R.id.editTextTextEdad);
        preferencias = findViewById(R.id.textViewPreferencias);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar();
                Toast.makeText(MainActivity.this, "Preferencias Guardadas", Toast.LENGTH_SHORT).show();
            }
        });

        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargar();
            }
        });

    }

    public void guardar(){

        editor.putString("nombre", String.valueOf(nombre.getText()));
        editor.putString("apellidos", String.valueOf(apellidos.getText()));
        editor.putString("edad", String.valueOf(edad.getText()));
        editor.apply();
    }

    public void cargar(){
        nombreS = misPreferencias.getString("nombre", "Nombre");
        apellidosS = misPreferencias.getString("apellidos", "Apellidos");
        edadS = misPreferencias.getString("edad", "Edad");
        preferencias.setText("Nombre: " + nombreS + "\nApellidos: " + apellidosS + "\nEdad: " + edadS);

    }
}