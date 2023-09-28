package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "item")
public class ItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private String nome;
    @Column(nullable = false)
    private double valor;
//    @ManyToOne
//    @JoinColumn(name = "rebelde_id")
//    private RebeldeModel rebeldeModel;

    public ItemModel(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

//    public RebeldeModel getRebeldeModel() {
//        return rebeldeModel;
//    }
//
//    public void setRebeldeModel(RebeldeModel rebeldeModel) {
//        this.rebeldeModel = rebeldeModel;
//    }

    public ItemModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
