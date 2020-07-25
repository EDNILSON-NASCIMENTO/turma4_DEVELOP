package com.generation.brazil.Turma4.repository;

import com.generation.brazil.Turma4.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface TurmaRepository extends JpaRepository<Turma,Long> {

    public ResponseEntity<Turma> findByDescription(String descricao);

    public Turma findByDescriptionClass(String descricao);
}
