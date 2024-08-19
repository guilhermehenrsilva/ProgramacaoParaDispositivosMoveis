package br.edu.ifsuldeminas.mch.GGL;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import br.edu.ifsuldeminas.mch.fuel.R;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText textInputEditTextEtanol;
    private TextInputEditText textInputEditTextGas;
    private Button btnCalcular;
    private ImageView imageViewResult;
    private ImageView imageViewShare;
    private TextView textViewResult;
    private String tip;
    private Double etanolPrice, gasPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputEditTextEtanol = findViewById(R.id.textInputEditTextEtanol);
        textInputEditTextGas = findViewById(R.id.textInputEditTextGas);
        btnCalcular = findViewById(R.id.buttonCalcular);
        imageViewResult = findViewById(R.id.imageViewFuel);
        imageViewShare = findViewById(R.id.imageViewShare);
        textViewResult = findViewById(R.id.textViewMessage);

        btnCalcular.setOnClickListener(view -> {
            String etanolPriceStr = textInputEditTextEtanol.getText().toString();
            String gasPrceStr = textInputEditTextGas.getText().toString();

            if(etanolPriceStr.equals("")){
                Toast.makeText(getApplicationContext(),"O valor do etanol não foi informado",
                        Toast.LENGTH_LONG).show();
                return;
            }

            if(gasPrceStr.equals("")){
                Toast.makeText(getApplicationContext(),"O valor da gasolina não foi informado",
                        Toast.LENGTH_LONG).show();
                return;
            }

            etanolPrice = Double.parseDouble(etanolPriceStr);
            gasPrice = Double.parseDouble(gasPrceStr);

            if(etanolPrice/gasPrice < 0.7){
                imageViewResult.setImageResource(R.drawable.ethanol);
                tip = "Melhor usar etanol";
            }else {
                imageViewResult.setImageResource(R.drawable.gas);
                tip = "Melhor usar gasolina";
            }

            textViewResult.setText(tip);
            imageViewResult.setVisibility(ImageView.VISIBLE);
            textViewResult.setVisibility(TextView.VISIBLE);
            imageViewShare.setVisibility(ImageView.VISIBLE);
        });

        imageViewShare.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Preços de qual posto?");
            LayoutInflater inflater = getLayoutInflater();
            View layoutDialogView = inflater.inflate(R.layout.alert_dialog_gas_station_view, null);

            builder.setView(layoutDialogView);

            builder.setNegativeButton("Cancelar", null);

            builder.setPositiveButton("Compartilhar", (dialogInterface, button ) ->{
                EditText editText = layoutDialogView.findViewById(R.id.editTextAlertDialogId);
                String posto = editText.getText().toString();

                if(posto.equals("")){
                    Toast toast = Toast.makeText(this, "Nome do posto não pode ser vazio", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                String message = String.format("Preço do posto '%s'. Gasolina: %.2f, Etanol: %.2f. %s. %.2fs"
                        , posto, gasPrice, etanolPrice,tip, etanolPrice/gasPrice+100, "%");

                Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
                toast.show();

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, message);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, "");

                startActivity(shareIntent);

            });

            builder.create().show();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        imageViewResult.setVisibility(ImageView.INVISIBLE);
        textViewResult.setVisibility(TextView.INVISIBLE);
        imageViewShare.setVisibility(ImageView.INVISIBLE);
    }


}