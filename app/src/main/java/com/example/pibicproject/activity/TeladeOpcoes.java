

package com.example.pibicproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pibicproject.R;

public class TeladeOpcoes extends AppCompatActivity {

    // Quando for colocar mais opções no menu colocar o nome do botão aqui

    private Button botaoiqa, botaogut, botaox;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telade_opcoes);

        // Observar que quando trocar em "private" a alteração do nome do botão mudar aqui tb

        botaoiqa = (Button) findViewById(R.id.BOTAOIQA);
        botaogut = (Button) findViewById(R.id.BOTAOGUT);
        botaox = (Button) findViewById(R.id.button5);

        // fazendo a chamada para cada botão

        botaoiqa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                botaoiqaActivity();

            }

        });

        botaogut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                botaogutActivity();
            }
        });
    }


    //adicionando as telas que vão ser direcionadas

    private void botaoiqaActivity() {

        startActivity(new Intent(TeladeOpcoes.this, MainActivity.class));

    }

    private void botaogutActivity() {

        startActivity(new Intent(TeladeOpcoes.this, Tela02.class));
    }
}
