package br.edu.ifsuldeminas.mch.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
<<<<<<< HEAD

public class MainActivity extends AppCompatActivity {
=======
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private Button buttonLogin ;

    private EditText userName;

    private EditText userPW;

    private static final String USER = "Guilherme";

    private static final String PW = "123";

    private static final String TAG = "login_main_activity";

>>>>>>> d9e25f5 (Atualizado 20/04/2024)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //acessar o botão
<<<<<<< HEAD
        Button buttonLogin = findViewById(R.id.buttonLogin);
        EditText userName = findViewById(R.id.editTextUser);
        EditText userPW = findViewById(R.id.editTextNumberPassword);

        // recuperando login e senha como string
       String userNameStr = userName.getText().toString();
       String userPWStr = userPW.getText().toString();


        buttonLogin.setOnClickListener(view -> {
           if (userNameStr.equals("")){
               Toast toast = Toast.makeText(view.getContext(),R.string.login_user_name_empty, Toast.LENGTH_SHORT);

               toast.show();
               return;
            }

           if (userPWStr.equals("")){
               Toast toast = Toast.makeText(view.getContext(),R.string.login_user_name_empty, Toast.LENGTH_SHORT);

               toast.show();
               return;
           }
        });


=======
        buttonLogin = findViewById(R.id.buttonLogin);
        userName = findViewById(R.id.editTextUser);
        userPW = findViewById(R.id.editTextNumberPassword);

        buttonLogin.setOnClickListener(view -> {
            // recuperando login e senha como string
            String userNameStr = userName.getText().toString();
            String userPWStr = userPW.getText().toString();

            if (userNameStr.equals("")) {
                Toast toast = Toast.makeText(view.getContext(),
                        R.string.login_user_name_empty, Toast.LENGTH_SHORT);

                toast.show();
                return;
            }

            if (userPWStr.equals("")) {
                Toast toast = Toast.makeText(view.getContext(),
                        R.string.login_user_pw_empty, Toast.LENGTH_SHORT);

                toast.show();
                return;
            }

            // há usuario e senha, vamos ver se estão corretos
            if (userNameStr.equals(USER) && userPWStr.equals(PW)) {

            } else {
                Toast toast = Toast.makeText(view.getContext(),
                        R.string.login_user_wrong_user_name_or_pw, Toast.LENGTH_SHORT);

                toast.show();

                Log.e(TAG, "Login e senha incorretos");
            }
        });


        Log.i(TAG, "O metodo onCreat executou sem erros ");

>>>>>>> d9e25f5 (Atualizado 20/04/2024)
        //passar uma View.onclickListener
        //Implementar uma subclasse  de View.onClickListener

    }
<<<<<<< HEAD
    public void forgotPW (View view)  {
        Toast toast = Toast.makeText(view.getContext(), R.string.login_user_forgotPw_message,Toast.LENGTH_LONG);
        toast.show();
    }
}
=======
            public void forgotPW (View view){
            Toast toast = Toast.makeText(view.getContext(), R.string.login_user_forgotPw_message, Toast.LENGTH_LONG);
            toast.show();
        }
    }
>>>>>>> d9e25f5 (Atualizado 20/04/2024)
