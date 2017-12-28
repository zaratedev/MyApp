package com.zaratedev.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button boton;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = findViewById(R.id.boton);
        texto = findViewById(R.id.texto);

        texto.setMovementMethod(new ScrollingMovementMethod());

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i <= 100; i++) {
                    cargarDatos("Número: "+ i);
                }
            }
        });
    }

    public void cargarDatos(String datos) {
        texto.append(datos + "\n" );
    }
}
