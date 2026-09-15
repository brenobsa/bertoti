package com.thehecklers.sburrestdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treinos")
public class TreinoController {

    @Autowired
    private TreinoRepository treinoRepository;

    @Autowired
    private ExercicioRepository exercicioRepository;

    // 1. Listar todos os treinos
    @GetMapping
    public List<Treino> getTreinos() {
        return treinoRepository.findAll();
    }

    // 2. Buscar treino específico
    @GetMapping("/{id}")
    public ResponseEntity<Treino> getTreino(@PathVariable String id) {
        return treinoRepository.findById(id.toUpperCase())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. Adicionar exercício
    @PostMapping("/{id}/exercicios")
    public ResponseEntity<Treino> adicionarExercicio(@PathVariable String id, @RequestBody Exercicio exercicio) {
        return treinoRepository.findById(id.toUpperCase()).map(treino -> {
            treino.adicionarExercicio(exercicio);
            Treino salvo = treinoRepository.save(treino);
            return ResponseEntity.ok(salvo);
        }).orElse(ResponseEntity.notFound().build());
    }

    // 4. Editar exercício
    @PutMapping("/exercicios/{exercicioId}")
    public ResponseEntity<Exercicio> editarExercicio(@PathVariable Long exercicioId, @RequestBody Exercicio dadosAtualizados) {
        return exercicioRepository.findById(exercicioId).map(exercicio -> {
            exercicio.setNome(dadosAtualizados.getNome());
            exercicio.setSeries(dadosAtualizados.getSeries());
            exercicio.setRepeticoes(dadosAtualizados.getRepeticoes());
            Exercicio salvo = exercicioRepository.save(exercicio);
            return ResponseEntity.ok(salvo);
        }).orElse(ResponseEntity.notFound().build());
    }

    // 5. Remover exercício
    @DeleteMapping("/exercicios/{exercicioId}")
    public ResponseEntity<Void> removerExercicio(@PathVariable Long exercicioId) {
        if (!exercicioRepository.existsById(exercicioId)) {
            return ResponseEntity.notFound().build();
        }
        exercicioRepository.deleteById(exercicioId);
        return ResponseEntity.noContent().build();
    }
}