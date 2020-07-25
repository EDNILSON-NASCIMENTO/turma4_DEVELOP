package com.generation.brazil.Turma4.repository;

import com.generation.brazil.Turma4.model.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

    ResponseEntity<Participante> findByName(String nome);

    void delete(ResponseEntity<Participante> participante);
}


