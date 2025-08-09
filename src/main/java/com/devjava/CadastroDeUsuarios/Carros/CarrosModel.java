package com.devjava.CadastroDeUsuarios.Carros;

import com.devjava.CadastroDeUsuarios.Usuario.UsuarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "tb_carros")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarrosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeDoCarro;

    private String marcaDoCarro;

    //@OneToMany Um carro pode ter varios motoristas
    @OneToMany(mappedBy = "carros")
    private List<UsuarioModel> usuarios;

}
