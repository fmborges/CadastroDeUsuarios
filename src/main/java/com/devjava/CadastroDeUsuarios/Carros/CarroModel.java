package com.devjava.CadastroDeUsuarios.Carros;

import com.devjava.CadastroDeUsuarios.Usuario.UsuarioModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "tb_carros")
public class CarroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeDoCarro;

    private String marcaDoCarro;

    //@OneToMany Um carro pode ter varios motoristas
    @OneToMany(mappedBy = "carros")
    private List<UsuarioModel> usuário;

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
