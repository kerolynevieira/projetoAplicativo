package com.example.pibicproject.activity;

import com.example.pibicproject.config.ConfiguracaoFirebase;
import com.example.pibicproject.helper.Base64Custom;
import com.example.pibicproject.helper.DateCustom;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class BaseMovimentacao {
    private String data;
    private String tipo;
    //private String valor;

    public String getData() {
        return data;
    }

    public String getTipo() {return tipo; }

    //public String getValor() {return  valor;}

    public void salvar(String dataEscolhida){

        FirebaseAuth autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        String idUsuario = Base64Custom.codificarBase64( autenticacao.getCurrentUser().getEmail());
        String mesAno = DateCustom.mesAnoDataEscolhida(dataEscolhida);

        DatabaseReference firebase = ConfiguracaoFirebase.getFirebaseDatabase();
        firebase.child("movimentacao")
                .child(idUsuario)
                .child(mesAno)
                .push()
                .setValue(this);

    }
}
