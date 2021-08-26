package com.example.pibicproject.activity;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pibicproject.R;

import java.util.ArrayList;

public class EtapasProblemasAdapter extends ArrayAdapter<EtapasProblemas> {


    private  final Context context;
    private final ArrayList<EtapasProblemas> elementos;

    // armazenando os dados

    public EtapasProblemasAdapter(Context context, ArrayList<EtapasProblemas> elementos){
        super(context, R.layout.linha, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    //


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha, parent, false);

        TextView nomeEtapa = (TextView) rowView.findViewById(R.id.nome);



        nomeEtapa.setText(elementos.get(position).getNome());

        //COMO COLOCAR AQUI A COR EM CADA ITEM DA LIST VIEW???
        if(position==0){
            rowView.setBackgroundColor(Color.parseColor("#006400"));
            nomeEtapa.setTextColor(Color.WHITE);

        }else if( position==1){
            rowView.setBackgroundColor(Color.parseColor("#006400"));
            nomeEtapa.setTextColor(Color.WHITE);

        }else if( position==2){
            rowView.setBackgroundColor(Color.parseColor("#228B22"));
            nomeEtapa.setTextColor(Color.WHITE);

        }else if( position==3){
            rowView.setBackgroundColor(Color.parseColor("#228B22"));
            nomeEtapa.setTextColor(Color.WHITE);

        }else if( position==4){
            rowView.setBackgroundColor(Color.parseColor("#228B22"));
            nomeEtapa.setTextColor(Color.WHITE);

        }else if( position==5){
            rowView.setBackgroundColor(Color.parseColor("#32CD32"));
            nomeEtapa.setTextColor(Color.WHITE);

        }else if( position==6){
            rowView.setBackgroundColor(Color.parseColor("#32CD32"));
            nomeEtapa.setTextColor(Color.WHITE);

        }else {
            rowView.setBackgroundColor(Color.parseColor("#9ACD32"));
            nomeEtapa.setTextColor(Color.WHITE);
        }







        return rowView;


    }


}
