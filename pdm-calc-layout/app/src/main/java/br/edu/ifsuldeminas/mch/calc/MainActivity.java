package br.edu.ifsuldeminas.mch.calc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.R.id;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ifsuldeminas.mch.calc";
    private Button buttonZero, buttonUm, buttonDois, buttonTres, buttonQuatro, buttonCinco,
            buttonSeis, buttonSete, buttonOito, buttonNove, buttonVirgula, buttonIgual,
            buttonSoma, buttonPorcento, buttonDelete, buttonReset,
            buttonDivisao, buttonMultiplicacao, buttonSubtracao;
    private TextView textViewResultado;
    private TextView textViewUltimaExpressao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        getSupportActionBar().hide();

        buttonZero.setOnClickListener(this);
        buttonUm.setOnClickListener(this);
        buttonDois.setOnClickListener(this);
        buttonTres.setOnClickListener(this);
        buttonQuatro.setOnClickListener(this);
        buttonCinco.setOnClickListener(this);
        buttonSeis.setOnClickListener(this);
        buttonSete.setOnClickListener(this);
        buttonOito.setOnClickListener(this);
        buttonNove.setOnClickListener(this);
        buttonVirgula.setOnClickListener(this);
        buttonSoma.setOnClickListener(this);
        buttonPorcento.setOnClickListener(this);
        buttonDivisao.setOnClickListener(this);
        buttonMultiplicacao.setOnClickListener(this);
        buttonSubtracao.setOnClickListener(this);

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.setText("");
                textViewResultado.setText("");
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView expressao = findViewById(R.id.textViewUltimaExpressaoID);
                String string = expressao.getText().toString();
                if(!string.isEmpty()){

                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtExpressao = string.substring(var0,var1);
                    expressao.setText(txtExpressao);
                }
                textViewResultado.setText("");
            }
        });

        buttonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Calculable expressao = new ExpressionBuilder(textViewUltimaExpressao.getText().toString()).build();
                    double resultado = expressao.calculate();
                    long longResult = (long) resultado;

                    if (resultado == (double) longResult) {
                        textViewResultado.setText((CharSequence) String.valueOf(longResult));
                        textViewUltimaExpressao.setText("");

                    } else {
                        textViewResultado.setText((CharSequence) String.valueOf(resultado));


                    }

                }catch (Exception e) {
                    textViewResultado.setText("[ERRO]");
                    textViewUltimaExpressao.setText("");

                }

            }
        });

        textViewResultado.setText("");

    }

    private void IniciarComponentes(){

        textViewResultado = findViewById(R.id.textViewResultadoID);
        textViewUltimaExpressao = findViewById(R.id.textViewUltimaExpressaoID);

        buttonIgual = findViewById(R.id.buttonIgualID);
        buttonZero = findViewById(R.id.buttonZeroID);
        buttonUm = findViewById(R.id.buttonUmID);
        buttonDois = findViewById(R.id.buttonDoisID);
        buttonTres = findViewById(R.id.buttonTresID);
        buttonQuatro = findViewById(R.id.buttonQuatroID);
        buttonCinco = findViewById(R.id.buttonCincoID);
        buttonSeis = findViewById(R.id.buttonSeisID);
        buttonSete = findViewById(R.id.buttonSeteID);
        buttonOito = findViewById(R.id.buttonOitoID);
        buttonNove = findViewById(R.id.buttonNoveID);
        buttonVirgula = findViewById(R.id.buttonVirgulaID);
        buttonIgual = findViewById(R.id.buttonIgualID);
        buttonSoma = findViewById(R.id.buttonSomaID);
        buttonPorcento = findViewById(R.id.buttonPorcentoID);
        buttonDelete = findViewById(R.id.buttonDeleteID);
        buttonReset = findViewById(R.id.buttonResetID);
        buttonDivisao = findViewById(R.id.buttonDivisaoID);
        buttonMultiplicacao = findViewById(R.id.buttonMultiplicacaoID);
        buttonSubtracao = findViewById(R.id.buttonSubtracaoID);
    }

    public void AcrescentarExpressao(String string, boolean limparDados){

        if (textViewResultado.getText().equals("")){
            textViewUltimaExpressao.setText((" "));
        }
        if (limparDados){
            textViewResultado.setText(" ");
            textViewUltimaExpressao.append(string);

        }else{
            textViewUltimaExpressao.append(textViewResultado.getText());
            textViewUltimaExpressao.append(string);
            textViewResultado.setText(" ");
        }

    }

    @Override
    public void onClick(View view) {
     switch (view.getId()){
         case R.id.buttonZeroID:
             AcrescentarExpressao("0", true);
             break;
         case R.id.buttonUmID:
             AcrescentarExpressao("1", true);
             break;
         case R.id.buttonDoisID:
             AcrescentarExpressao("2", true);
             break;
         case R.id.buttonTresID:
             AcrescentarExpressao("3", true);
             break;
         case R.id.buttonQuatroID:
             AcrescentarExpressao("4", true);
             break;
         case R.id.buttonCincoID:
             AcrescentarExpressao("5", true);
             break;
         case R.id.buttonSeisID:
             AcrescentarExpressao("6", true);
             break;
         case R.id.buttonSeteID:
             AcrescentarExpressao("7", true);
             break;
         case R.id.buttonOitoID:
             AcrescentarExpressao("8", true);
             break;
         case R.id.buttonNoveID:
             AcrescentarExpressao("9", true);
             break;
         case R.id.buttonVirgulaID:
             AcrescentarExpressao(".", true);
             break;

         case R.id.buttonSomaID:
             AcrescentarExpressao("+", false);
             break;

         case R.id.buttonSubtracaoID:
             AcrescentarExpressao("-", false);
             break;

         case R.id.buttonPorcentoID:
             AcrescentarExpressao("%", false);
             break;
         case R.id.buttonDivisaoID:
             AcrescentarExpressao("/", false);
             break;
         case R.id.buttonMultiplicacaoID:
             AcrescentarExpressao("*", false);
             break;

     }
     }

}