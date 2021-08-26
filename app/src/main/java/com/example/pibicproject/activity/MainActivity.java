package com.example.pibicproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pibicproject.R;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText editiqa;
    private TextView textresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editiqa = findViewById(R.id.editiqa);
        textresultado = findViewById(R.id.textresultado);
    }

    public void calcularoresultado(View view){

        //recuperando os valores digitados
        String valoriqa = editiqa.getText().toString();

        //validando o campo digitado
        Boolean camposValidados = validarCampos(valoriqa);
        if (camposValidados) {

            //convertendo string para numeros
            Double numeroiqa = Double.parseDouble(valoriqa);

            //calculo do resultado
            double resultado = numeroiqa;
            if( resultado <= 19.0 ) {
                textresultado.setText("Péssima");
                textresultado.setBackgroundColor(Color.parseColor("#6A5ACD"));

            }else if (resultado > 19.0 && resultado <= 36){
                textresultado.setText("Ruim");
                textresultado.setBackgroundColor(Color.parseColor("#FF0000"));

            }else if (resultado > 36.0 && resultado <= 51.0){
                textresultado.setText("Regular");
                textresultado.setBackgroundColor(Color.parseColor("#FFFF00"));

            }else if(resultado > 51.0 && resultado <= 79.0){
                textresultado.setText("Boa");
                textresultado.setBackgroundColor(Color.parseColor("#008000"));

            }else{
                textresultado.setText("Ótima");
                textresultado.setBackgroundColor(Color.parseColor("#0000FF"));
            }

        }else{
            textresultado.setText("Preencha o campo primeiro!");
        }

    }

    public Boolean validarCampos( String piqa){

        Boolean camposValidados = true;


        if (piqa == null || piqa.equals("")  ){
            camposValidados = false;


        }

        return camposValidados;

    }
}