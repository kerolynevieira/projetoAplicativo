package com.example.pibicproject.helper;

import android.util.Log;

import java.text.SimpleDateFormat;

public class DateCustom {
    public static String dataAtual(){
        long data = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String dataString = simpleDateFormat.format(data);
        return dataString;

    }

    public static  String mesAnoDataEscolhida(String data){

        String retornoData[] = data.split(("/"));
        String dia = retornoData[0]; //dia 28
        String mes = retornoData[1]; //dia 07
        String ano = retornoData[2]; //dia 2021

        String mesAno = mes + ano;
        return mesAno;

    }
}
