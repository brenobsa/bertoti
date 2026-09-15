package com.thehecklers.sburrestdemo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
@Table(name = "exercicios")
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int series;

    @Column(nullable = false)
    private int repeticoes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treino_id", nullable = false)
    @JsonBackReference
    private Treino treino;

    public Exercicio() {}

    public Exercicio(String nome, int series, int repeticoes) {
        this.nome = nome;
        this.series = series;
        this.repeticoes = repeticoes;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getSeries() { return series; }
    public void setSeries(int series) { this.series = series; }

    public int getRepeticoes() { return repeticoes; }
    public void setRepeticoes(int repeticoes) { this.repeticoes = repeticoes; }

    public Treino getTreino() { return treino; }
    public void setTreino(Treino treino) { this.treino = treino; }
}