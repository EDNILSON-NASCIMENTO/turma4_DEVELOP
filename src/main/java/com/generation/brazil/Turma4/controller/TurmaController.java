package com.generation.brazil.Turma4.controller;

import com.generation.brazil.Turma4.exception.ResourceNotFoundException;
import com.generation.brazil.Turma4.model.Turma;
import com.generation.brazil.Turma4.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/turma/v1")
public class TurmaController {

    @Autowired
    TurmaRepository turmaRepository;

    //CRUD
    //-----------------------------------------
    //CREATE
    @PostMapping("/turma")
    public Turma salvarTurma(@RequestBody Turma dadosTurma){
        return turmaRepository.save(dadosTurma);
    };

    //READ
    @GetMapping("/turma/{id}")
    public ResponseEntity<Turma> buscaTurmaPorId(@PathVariable(value = "id") Long turmaId)
        throws ResourceNotFoundException{
            Turma turma = turmaRepository.findById(turmaId)
                    .orElseThrow(() -> new ResourceNotFoundException("Essa turma não existe para esse id"));
        return ResponseEntity.ok().body(turma);
    }

    @GetMapping("/turma/{descricao}")
    public ResponseEntity<Turma> buscaTurmaPorNome(@PathVariable(value = "descricao") String descricao){
        return turmaRepository.findByDescription(descricao);
    }

    //UPDATE
    @PatchMapping("/turma/{id}")
    public ResponseEntity<Turma> updateTurma(@PathVariable(value = "id") Long turmaId,
                                           @Valid @RequestBody Turma detalhesDaTurma) {
       Turma turma = turmaRepository.findById(turmaId)
                .orElseThrow(() -> new ResourceNotFoundException("Não existe turma para esse id"));

        turma.setTipo(detalhesDaTurma.getTipo());
        turma.setDescricao(detalhesDaTurma.getDescricao());
        turma.getParticipante(detalhesDaTurma.getDescricao());

        final Turma atualizaTurma = turmaRepository.save(turma);
        return ResponseEntity.ok(atualizaTurma);
    }

    //DELETE
    @DeleteMapping("turma/{descricao}")
    public Map<String, Boolean> deletaTurma(@PathVariable(value = "descricao") String descricao)
            throws ResourceNotFoundException {
        Turma turma = turmaRepository.findByDescriptionClass(descricao);
        turmaRepository.delete(turma);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
