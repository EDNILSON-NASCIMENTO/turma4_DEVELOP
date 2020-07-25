package com.generation.brazil.Turma4.controller;

import com.generation.brazil.Turma4.exception.ResourceNotFoundException;
import com.generation.brazil.Turma4.model.Participante;
import com.generation.brazil.Turma4.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/participantes/v1")
public class ParticipanteController {

    @Autowired
    ParticipanteRepository participanteRepository;

    //CRUD
    //-----------------------------------------
    //CREATE
    @PostMapping("/participante")
    public Participante salvarParticipante(@RequestBody Participante dadosParticipante){
        return participanteRepository.save(dadosParticipante);
    };

    //READ
    @GetMapping("/participante/{id}")
    public ResponseEntity<Participante> buscaParticipantePorId(@PathVariable(value = "id") Long participanteId)
            throws ResourceNotFoundException {
        Participante participante = participanteRepository.findById(participanteId)
                .orElseThrow(() -> new ResourceNotFoundException("Esse participante não existe para esse id"));
        return ResponseEntity.ok().body(participante);
    }

    @GetMapping("/participante/{nome}")
    public ResponseEntity<Participante> buscaParticipantePorNome(@PathVariable(value = "nome") String nome){
        return participanteRepository.findByName(nome);
    }

    //UPDATE
    @PatchMapping("/participante/{id}")
    public ResponseEntity<Participante> updateParticipante(@PathVariable(value = "id") Long participanteId,
                                             @Valid @RequestBody Participante detalhesDoParticipante) {
        Participante participante = participanteRepository.findById(participanteId)
                .orElseThrow(() -> new ResourceNotFoundException("Não existe participante para esse id"));

        participante.setNome(detalhesDoParticipante.getNome());
        participante.setEmail(detalhesDoParticipante.getEmail());
        participante.setObservacoes(detalhesDoParticipante.getObservacoes());
        participante.setTurma(detalhesDoParticipante.getTurma());

        final Participante atualizaParticipante = participanteRepository.save(participante);
        return ResponseEntity.ok(atualizaParticipante);
    }

    //DELETE
    @DeleteMapping("/participante/{id}")
    public void deleteParticipante(@PathVariable Long id){
        participanteRepository.deleteById(id);
    }
    @DeleteMapping("participante/{nome}")
    public Map<String, Boolean> deletaParticipantePorNome(@PathVariable(value = "nome") String nome)
            throws ResourceNotFoundException {
        ResponseEntity<Participante> participante = participanteRepository.findByName(nome);
        participanteRepository.delete(participante);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
