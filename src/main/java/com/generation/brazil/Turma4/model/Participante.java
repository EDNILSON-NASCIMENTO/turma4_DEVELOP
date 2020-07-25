package com.generation.brazil.Turma4.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Participante {
    private Long participanteId;
    private String nome;
    private String email;
    private String observacoes;
    private Turma turma;

    public Participante(Long participanteId, String nome, String email, String observacoes, Turma turma) {
        this.participanteId = participanteId;
        this.nome = nome;
        this.email = email;
        this.observacoes = observacoes;
        this.turma = turma;
    }

    public Long getParticipanteId() {
        return participanteId;
    }

    public void setParticipanteId(Long participanteId) {
        this.participanteId = participanteId;
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

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
