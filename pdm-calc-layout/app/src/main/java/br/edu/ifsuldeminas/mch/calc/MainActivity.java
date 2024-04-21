package br.edu.ifsuldeminas.mch.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG = "ifsuldeminas.mch.calc";
    private Button buttonIgual, buttonUm, buttonDois, buttonTres, buttonQuatro, buttonCinco,
            buttonSeis, buttonSete, buttonOito, buttonNove, buttonZero, buttonPonto, buttonReset,
            buttonAdicao, buttonSubtracao, buttonMultiplicacao, buttonDivisao, buttonLimpar;
    ;
    private TextView textViewResultado;
    private TextView textViewUltimaExpressao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResultado = findViewById(R.id.textViewResultadoID);
        textViewUltimaExpressao = findViewById(R.id.textViewUltimaExpressaoID);

        buttonIgual = findViewById(R.id.buttonIgualID);
        buttonUm = findViewById(R.id.buttonUmID);
        buttonDois = findViewById(R.id.buttonDoisID);
        buttonTres = findViewById(R.id.buttonTresID);
        buttonQuatro = findViewById(R.id.buttonQuatroID);
        buttonCinco = findViewById(R.id.buttonCincoID);
        buttonSeis = findViewById(R.id.buttonSeisID);
        buttonSete = findViewById(R.id.buttonSeteID);
        buttonOito = findViewById(R.id.buttonOitoID);
        buttonNove = findViewById(R.id.buttonNoveID);
        buttonZero = findViewById(R.id.buttonZeroID);
        buttonPonto = findViewById(R.id.buttonVirgulaID);
        buttonAdicao = findViewById(R.id.buttonSomaID);
        buttonSubtracao = findViewById(R.id.buttonSubtracaoID);
        buttonMultiplicacao = findViewById(R.id.buttonMultiplicacaoID);
        buttonDivisao = findViewById(R.id.buttonDivisaoID);
        buttonLimpar = findViewById(R.id.buttonResetID);




        buttonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculable avaliadorExpressao = null;
                try {
                    String expressao = "5+1+4*2";
                    avaliadorExpressao = new ExpressionBuilder(expressao).build();

                    Double resultado = avaliadorExpressao.calculate();

                    textViewUltimaExpressao.setText(expressao);
                    textViewResultado.setText(resultado.toString());
                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });

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
        buttonPonto.setOnClickListener(this);
        buttonAdicao.setOnClickListener(this);
        buttonSubtracao.setOnClickListener(this);
        buttonMultiplicacao.setOnClickListener(this);
        buttonDivisao.setOnClickListener(this);
        buttonIgual.setOnClickListener(this);


        buttonReset.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.setText("");
                textViewResultado.setText("");
            }
        });

        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView expressao = findViewById(R.id.textViewUltimaExpressaoID);
                String string = expressao.getText().toString();

                if (!string.isEmpty()){
                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String textExpressao = string.substring(var0, var1);
                    expressao.setText(textExpressao);
                }
                textViewResultado.setText("");
            }
        });

//        buttonIgual.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    Expression expressao = new ExpressionBuilder(textViewUltimaExpressao.getText().toString()).build();
//                    double resultado = expressao.evaluate();
//
//                    long longResult = (long) resultado;
//                    if(resultado == (double) longResult){
//                        textViewResultado.setText((CharSequence) String.valueOf(longResult));
//                    }else{
//                        textViewResultado.setText((CharSequence) String.valueOf(resultado));
//                    }
//                }catch (Exception e){
//
//                }
//            }
//        });

    }

    public void AcrescentarUmaExpressao(String string, boolean limpar_dados){
        if (textViewResultado.getText().equals("")){
            textViewUltimaExpressao.setText(" ");
        }
        if (limpar_dados){
            textViewResultado.setText(" ");
            textViewUltimaExpressao.append(string);
        } else {
            textViewUltimaExpressao.append(textViewResultado.getText());
            textViewUltimaExpressao.append(string);
            textViewResultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.buttonZeroID:
             AcrescentarUmaExpressao("0", true );
             break;

            case R.id.buttonUmID:
                AcrescentarUmaExpressao("1", true);
                break;
            case R.id.buttonDoisID:
                AcrescentarUmaExpressao("2", true);
                break;
            case R.id.buttonTresID:
                AcrescentarUmaExpressao("3", true);
                break;
            case R.id.buttonQuatroID:
                AcrescentarUmaExpressao("4", true);
                break;
            case R.id.buttonCincoID:
                AcrescentarUmaExpressao("5", true);
                break;
            case R.id.buttonSeisID:
                AcrescentarUmaExpressao("6", true);
                break;
            case R.id.buttonSeteID:
                AcrescentarUmaExpressao("7", true);
                break;
            case R.id.buttonOitoID:
                AcrescentarUmaExpressao("8", true);
                break;
            case R.id.buttonNoveID:
                AcrescentarUmaExpressao("9", true);
                break;
            case R.id.buttonVirgulaID:ID:
                AcrescentarUmaExpressao(".", true);
                break;
            case R.id.buttonSomaID:ID:
                AcrescentarUmaExpressao("+", true);
                break;
            case R.id.buttonSubtracaoID:
                AcrescentarUmaExpressao("-", true);
                break;
            case R.id.buttonMultiplicacaoID:
                AcrescentarUmaExpressao("*", true);
                break;
            case R.id.buttonDivisaoID:
                AcrescentarUmaExpressao("/", true);
                break;
            case R.id.buttonIgualID:
                AcrescentarUmaExpressao("=",true);
                break;

        }
    }
}