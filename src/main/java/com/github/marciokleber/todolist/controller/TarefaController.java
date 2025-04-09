package com.github.marciokleber.todolist.controller;

import com.github.marciokleber.todolist.domain.Tarefa;
import com.github.marciokleber.todolist.repository.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
@AllArgsConstructor
public class TarefaController {

    private TarefaRepository tarefaRepository;

    @GetMapping
    public ResponseEntity<List<Tarefa>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(tarefaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> findAll(@PathVariable Long id){
        var tarefa = tarefaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return ResponseEntity.status(HttpStatus.OK).body(tarefa);
    }

    @PostMapping
    public ResponseEntity<Tarefa> create(@RequestBody Tarefa tarefa){
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaRepository.save(tarefa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> update(@PathVariable Long id, @RequestBody Tarefa tarefaUpdated){
        var tarefa = tarefaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        BeanUtils.copyProperties(tarefaUpdated,tarefa, "id");
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaRepository.save(tarefa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        tarefaRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
