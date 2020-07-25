package com.generation.brazil.Turma4.model;


import lombok.*;

//
//@Getter
//@Setter
@Data
public class Turma {
    private Long turmaId;
    private String descricao;
    private String tipo;
    private Participante participante;

    public Turma(){

    }

    public Turma(Long turmaId, String descricao, String tipo, Participante participante) {
        this.turmaId = turmaId;
        this.descricao = descricao;
        this.tipo = tipo;
        this.participante = participante;
    }

    public Long getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Long turmaId) {
        this.turmaId = turmaId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Participante getParticipante(String descricao) {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
}
