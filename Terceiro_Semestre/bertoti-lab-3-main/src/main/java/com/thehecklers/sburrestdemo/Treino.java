package com.thehecklers.sburrestdemo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "treinos")
public class Treino {

    @Id
    @Column(length = 5)
    private String identificador;

    @Column(name = "grupo_muscular")
    private String grupoMuscular;

    @OneToMany(mappedBy = "treino", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Exercicio> exercicios = new ArrayList<>();

    public Treino() {}

    public Treino(String identificador, String grupoMuscular) {
        this.identificador = identificador;
        this.grupoMuscular = grupoMuscular;
    }

    public String getIdentificador() { return identificador; }
    public void setIdentificador(String identificador) { this.identificador = identificador; }

    public String getGrupoMuscular() { return grupoMuscular; }
    public void setGrupoMuscular(String grupoMuscular) { this.grupoMuscular = grupoMuscular; }

    public List<Exercicio> getExercicios() { return exercicios; }
    public void setExercicios(List<Exercicio> exercicios) { this.exercicios = exercicios; }

    public void adicionarExercicio(Exercicio exercicio) {
        this.exercicios.add(exercicio);
        exercicio.setTreino(this);
    }
}