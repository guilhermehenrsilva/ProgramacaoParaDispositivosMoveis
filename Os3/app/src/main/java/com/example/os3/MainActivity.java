package com.example.os3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_trab1 = findViewById(R.id.button_trab1);
        Button button_trab2 = findViewById(R.id.button_trab2);
        Button button_trab3 = findViewById(R.id.button_trab3);


        button_trab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, tela_trab1.class);
                startActivity(intent);
            }
        });

        button_trab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, tela_trab_3.class);
                startActivity(intent);
            }
        });

        button_trab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, tela_trab4.class);
                startActivity(intent);
            }
        });
    }
}