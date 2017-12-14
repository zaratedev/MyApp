package com.zaratedev.myapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView texto;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = findViewById(R.id.texto);
        boton = findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MyAsycTask().execute(100);
            }
        });
    }


    public class MyAsycTask extends AsyncTask<Integer, Integer, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Integer... integers) {
            int max = integers[0];

            for (int i = 1; i < max; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                publishProgress(i);
            }
            return "End";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            int contador = values[0];
            String text = "Contador" + contador;

            texto.setText(text);
            texto.setTextSize(contador);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            texto.append("\n" + s);
        }
    }
}
