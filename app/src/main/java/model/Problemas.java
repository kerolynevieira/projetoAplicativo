package model;

import android.widget.Spinner;

public class Problemas {


    private Long id;
    private String problema;
    private Integer Gravidade;
    private Integer Tendencia;
    private Integer Urgencia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public Integer getGravidade() {
        return Gravidade;
    }

    public void setGravidade(Integer gravidade) {
        Gravidade = gravidade;
    }

    public Integer getTendencia() {
        return Tendencia;
    }

    public void setTendencia(Integer tendencia) {
        Tendencia = tendencia;
    }

    public Integer getUrgencia() {
        return Urgencia;
    }

    public void setUrgencia(Integer urgencia) {
        Urgencia = urgencia;
    }
}


