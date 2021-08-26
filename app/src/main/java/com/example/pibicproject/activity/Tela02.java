package com.example.pibicproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pibicproject.R;

import java.util.ArrayList;



public class Tela02 extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela02);

        ListView lista = (ListView) findViewById(R.id.lt_etapas);
        ArrayList<EtapasProblemas> etapasProblema = listaEtapas();
        ArrayAdapter adapter = new EtapasProblemasAdapter(this, etapasProblema);
        lista.setAdapter(adapter);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
               Intent intent = new Intent(Tela02.this, FormularioProblemas.class);

               intent.putExtra("nome", etapasProblema.get(i).getNome());
//                intent.putExtra("tipo", etapasProblema.get(i).getTipo());
                startActivity(intent);
                finish();

            }
        });


    }

    private ArrayList<EtapasProblemas> listaEtapas() {
        ArrayList<EtapasProblemas> etapasProblema = new ArrayList<EtapasProblemas>();
        EtapasProblemas e = new EtapasProblemas("ETE: Uso de Produtos Químicos");
        etapasProblema.add(e);

        e= new EtapasProblemas("ETE: Uso Inadequado de Água");
        etapasProblema.add(e);

        e= new EtapasProblemas("ACABAMENTO: Efluente Gerado");
        etapasProblema.add(e);

        e= new EtapasProblemas("ACABAMENTO: Efluente de Metais Pesados Criados");
        etapasProblema.add(e);

        e= new EtapasProblemas("ACABAMENTO: Liberação de Vapores");
        etapasProblema.add(e);

        e= new EtapasProblemas("LAVAGEM: Efluente Químico Gerado");
        etapasProblema.add(e);

        e= new EtapasProblemas("LAVAGEM: Uso Inadequado de Água");
        etapasProblema.add(e);

        e= new EtapasProblemas("GERAÇÃO DE VAPOR: Uso Inadequado de Água");
        etapasProblema.add(e);

        e= new EtapasProblemas("GERAÇÃO DE VAPOR: Geração de Gases");
        etapasProblema.add(e);

        e= new EtapasProblemas("GERAÇÃO DE VAPOR: Ausência de Documento de Origem Florestal");
        etapasProblema.add(e);

        return etapasProblema;
    }

}