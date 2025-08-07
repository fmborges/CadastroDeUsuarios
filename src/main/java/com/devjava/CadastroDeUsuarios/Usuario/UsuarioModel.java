package com.devjava.CadastroDeUsuarios.Usuario;


import com.devjava.CadastroDeUsuarios.Carros.CarroModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//Entity transforma uma classe comum em uma entidade
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    //@ManyToOne um usuário so pode ter um unico carro
    @ManyToOne
    @JoinColumn(name = "carros_id")  //chave estrangeira
    private CarroModel carros;

}
