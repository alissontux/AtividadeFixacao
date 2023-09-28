package org.example.controller;

import java.util.Map;

public class RebeldeRequest {
    private String nome;
    private int idade;
    private String genero;
    private String localizacao;
    private double moedas;
    private Map<String, Double> inventario;

    public RebeldeRequest(String nome, int idade, String genero, String localizacao, double moedas, Map<String, Double> inventario) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.localizacao = localizacao;
        this.moedas = moedas;
        this.inventario = inventario;
    }

    public double getMoedas() {
        return moedas;
    }

    public void setMoedas(double moedas) {
        this.moedas = moedas;
    }

    public RebeldeRequest() {
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

    public Map<String, Double> getInventario() {
        return inventario;
    }

    public void setInventario(Map<String, Double> inventario) {
        this.inventario = inventario;
    }
}
