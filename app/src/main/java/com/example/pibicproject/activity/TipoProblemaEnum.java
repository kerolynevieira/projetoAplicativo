package com.example.pibicproject.activity;

public enum TipoProblemaEnum {
    ETEprodutosQuimicos("ETE: Produtos Químicos"),
    ETEUsoDeAgua("ETE: Uso Inadequado de Água"),
    ACAEfluente("ACABAMENTO: Efluente Gerado"),
    ACAMetais("ACABAMENTO: Efluente de Metais Pesados Criados"),
    ACAVapores("ACABAMENTO:Liberação de Vapores"),
    LAVEfluente("LAVAGEM:Efluente Químico Gerado"),
    LAVAUsoDeAgua("LAVAGEM: Uso Inadequado de Água"),
    GERUsodeAgua("GERAÇÃO DE VAPOR: Uso Inadequado de Água"),
    GERGases("GERAÇÃO DE VAPOR: Geração de Gases"),
    GERDocumeto("GERAÇÃO DE VAPOR: Ausência de Documento de Origem Florestal");


    public String nome;

    TipoProblemaEnum(String nome) {
        this.nome = nome;
    }

    public String getNome() {return nome; }
}

