package com.example.pibicproject.model;

import com.example.pibicproject.activity.TipoProblemaEnum;
import com.example.pibicproject.config.ConfiguracaoFirebase;
import com.example.pibicproject.helper.Base64Custom;
import com.example.pibicproject.helper.DateCustom;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class Movimentacao {
    private String data;
    /*private String ACAefluente;
    private String ACAmetais;
    private String ACAquimico;
    private String ETEagua;
    private String ETEprodutos;
    private String GERagua;
    private String GERdocumento;
    private String GERgases;
    private String LAVagua;
    private String LAVquimico; */

    private TipoProblemaEnum tipoProblemaEnum;




    public Movimentacao() {
    }

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


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public TipoProblemaEnum getTipoProblemaEnum() {
        return tipoProblemaEnum;
    }

    public void setTipoProblemaEnum(TipoProblemaEnum tipoProblemaEnum) {
        this.tipoProblemaEnum = tipoProblemaEnum;
    }



    /*public String getACAefluente() {
        return ACAefluente;
    }

    public void setACAefluente(String ACAefluente) {
        this.ACAefluente = ACAefluente;
    }

    public String getACAmetais() {
        return ACAmetais;
    }

    public void setACAmetais(String ACAmetais) {
        this.ACAmetais = ACAmetais;
    }

    public String getACAquimico() {
        return ACAquimico;
    }

    public void setACAquimico(String ACAquimico) {
        this.ACAquimico = ACAquimico;
    }

    public String getETEagua() {
        return ETEagua;
    }

    public void setETEagua(String ETEagua) {
        this.ETEagua = ETEagua;
    }

    public String getETEprodutos() {
        return ETEprodutos;
    }

    public void setETEprodutos(String ETEprodutos) {
        this.ETEprodutos = ETEprodutos;
    }

    public String getGERagua() {
        return GERagua;
    }

    public void setGERagua(String GERagua) {
        this.GERagua = GERagua;
    }

    public String getGERdocumento() {
        return GERdocumento;
    }

    public void setGERdocumento(String GERdocumento) {
        this.GERdocumento = GERdocumento;
    }

    public String getGERgases() {
        return GERgases;
    }

    public void setGERgases(String GERgases) {
        this.GERgases = GERgases;
    }

    public String getLAVagua() {
        return LAVagua;
    }

    public void setLAVagua(String LAVagua) {
        this.LAVagua = LAVagua;
    }

    public String getLAVquimico() {
        return LAVquimico;
    }

    public void setLAVquimico(String LAVquimico) {
        this.LAVquimico = LAVquimico;
    } */


}
