package com.mths.linguagensapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class LinguagemControle {
    @Autowired
    private LinguagemRepository repositorio;
    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens(){
        List<Linguagem> linguagens = repositorio.findByOrderByRanking();
        return linguagens;
    }

    @PostMapping("/linguagens") //Liberar para que o postman possa fazer o post
    public ResponseEntity<Linguagem> cadastrarLinguagem(@RequestBody Linguagem linguagem) {
        return new ResponseEntity<>(repositorio.save(linguagem), HttpStatus.CREATED); //salvando

    }

    @GetMapping("/linguagens/{id}")
    public Linguagem obterLinguagemId(@PathVariable String id) {
        return repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/linguagens/{id}") //Para atualizar uma linguagem
    public Linguagem atualizarLinguagem(@PathVariable String id, @RequestBody Linguagem linguagem) { // request body pega o que está no body
        if (!repositorio.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (linguagem.getRanking() > repositorio.count()) { // erro se for colocado um ranking maior que a quantidade de linguagens que existem no banco
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

        linguagem.setId(id);
        Linguagem linguagemSalva = repositorio.save(linguagem);
        return linguagemSalva;
    }


    @DeleteMapping("/linguagens/{id}") // deletar linguagem
    public void linguagemDeleta(@PathVariable String id) {
        repositorio.deleteById(id);
    }
}
