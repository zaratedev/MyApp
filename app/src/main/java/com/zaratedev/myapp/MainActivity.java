package com.zaratedev.myapp;

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

        texto = (TextView) findViewById(R.id.texto);
        boton = (Button) findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final String text = "New text";
                        // First method
                        /*texto.post(new Runnable() {
                            @Override
                            public void run() {
                                texto.setText(text);
                            }
                        });*/

                        // second method
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                texto.setText(text);
                            }
                        });


                    }
                }).start();

                /*Hilo hilo = new Hilo();
                hilo.start();*/
            }
        });
    }

    /*public class Hilo extends Thread {
        public void run(){
            for (int i = 1; i <= 10; i++) {
                //texto.setText(String.valueOf(i));

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Log.e("DEBUG", String.valueOf(i));
            }
        }
    }*/
}
