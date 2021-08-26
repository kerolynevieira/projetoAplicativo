package com.example.pibicproject.model;

import com.example.pibicproject.config.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private String idUsuario;
    private Double ttACAefluente = 0.00;
    private Double ttACAmetais = 0.00;
    private Double ttACAquimico = 0.00;
    private Double ttEETEagua = 0.00;
    private Double ttETEprodutos = 0.00;
    private Double ttGERagua = 0.00;
    private Double ttGERdocumento = 0.00;
    private Double ttGERgases = 0.00;
    private Double ttLAVagua = 0.00;
    private Double ttLAVquimico = 0.00;


    //adicionando o construtor vazio
    public Usuario() {
    }


    //criando um metodo para salvar

    public void salvar() {

        //retornar o objeto para o banco de dados

        DatabaseReference firebase = ConfiguracaoFirebase.getFirebaseDatabase();
        firebase.child("usuarios")
                .child(this.idUsuario)
                .setValue(this);
    }

    //começa aqui o double

    public Double getTtACAefluente() { return ttACAefluente; }

    public void setTtACAefluente(Double ttACAefluente) {
        this.ttACAefluente = ttACAefluente;
    }

    public Double getTtACAmetais() {
        return ttACAmetais;
    }

    public void setTtACAmetais(Double ttACAmetais) {
        this.ttACAmetais = ttACAmetais;
    }

    public Double getTtACAquimico() {
        return ttACAquimico;
    }

    public void setTtACAquimico(Double ttACAquimico) {
        this.ttACAquimico = ttACAquimico;
    }

    public Double getTtEETEagua() {
        return ttEETEagua;
    }

    public void setTtEETEagua(Double ttEETEagua) {
        this.ttEETEagua = ttEETEagua;
    }

    public Double getTtETEprodutos() {
        return ttETEprodutos;
    }

    public void setTtETEprodutos(Double ttETEprodutos) {
        this.ttETEprodutos = ttETEprodutos;
    }

    public Double getTtGERagua() {
        return ttGERagua;
    }

    public void setTtGERagua(Double ttGERagua) {
        this.ttGERagua = ttGERagua;
    }

    public Double getTtGERdocumento() {
        return ttGERdocumento;
    }

    public void setTtGERdocumento(Double ttGERdocumento) {
        this.ttGERdocumento = ttGERdocumento;
    }

    public Double getTtGERgases() {
        return ttGERgases;
    }

    public void setTtGERgases(Double ttGERgases) {
        this.ttGERgases = ttGERgases;
    }

    public Double getTtLAVagua() {
        return ttLAVagua;
    }

    public void setTtLAVagua(Double ttLAVagua) {
        this.ttLAVagua = ttLAVagua;
    }

    public Double getTtLAVquimico() {
        return ttLAVquimico;
    }

    public void setTtLAVquimico(Double ttLAVquimico) {
        this.ttLAVquimico = ttLAVquimico;
    }


    //termina aqui o double


    @Exclude
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   @Exclude
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

