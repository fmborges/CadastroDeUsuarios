package com.devjava.CadastroDeUsuarios.Missoes;

import jakarta.persistence.*;

@Entity
@Table (name = "tb_carros")
public class CarroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeDoCarro;

    private String marcaDoCarro;

    public CarroModel() {
    }

    public CarroModel(String nomeDoCarro, String marcaDoCarro) {
        this.nomeDoCarro = nomeDoCarro;
        this.marcaDoCarro = marcaDoCarro;
    }

    public String getNomeDoCarro() {
        return nomeDoCarro;
    }

    public void setNomeDoCarro(String nomeDoCarro) {
        this.nomeDoCarro = nomeDoCarro;
    }

    public String getMarcaDoCarro() {
        return marcaDoCarro;
    }

    public void setMarcaDoCarro(String marcaDoCarro) {
        this.marcaDoCarro = marcaDoCarro;
    }
}
