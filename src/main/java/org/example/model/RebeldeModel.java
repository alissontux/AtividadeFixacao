package org.example.model;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "rebeldes")
public class RebeldeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private String nome;
    @Column(nullable = false, length = 3)
    private int idade;
    @Column(nullable = false, length = 12)
    private String genero;
    @Column(nullable = false, length = 200)
    private String localizacao;
    @Column(name = "traidor")
    private boolean traidor;
    @Column(name = "reportes_Traicao")
    private int reportesTraicao;
    @Column(name = "rebelde_Ativo")
    private boolean rebeldeAtivo = true;


    public RebeldeModel(String nome, int idade, String genero, String localizacao) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.localizacao = localizacao;
    }

    public RebeldeModel() {
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public boolean isTraidor() {
        return traidor;
    }

    public void setTraidor(boolean traidor) {
        this.traidor = traidor;
    }

    public int getReportesTraicao() {
        return reportesTraicao;
    }

    public void setReportesTraicao(int reportesTraicao) {
        this.reportesTraicao = reportesTraicao;
    }

    public boolean isRebeldeAtivo() {
        return rebeldeAtivo;
    }

    public void setRebeldeAtivo(boolean rebeldeAtivo) {
        this.rebeldeAtivo = rebeldeAtivo;
    }

    public void incrementarreportestraicao(){
        reportesTraicao++;
    }

    public void adicionarItemAoInventario(ItemModel itemSelecionado) {

    }
}
