package br.edu.ifsuldeminas.mch.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //acessar o botão
        Button buttonLogin = findViewById(R.id.buttonLogin);

        //acessar o onClickListener
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(),
                        R.string.login_succefull,Toast.LENGTH_LONG);

                toast.show();
            }
        });

        //passar uma View.onclickListener
        //Implementar uma subclasse  de View.onClickListener

    }
}