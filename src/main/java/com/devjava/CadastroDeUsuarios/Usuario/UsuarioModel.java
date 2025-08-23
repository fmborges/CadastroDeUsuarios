package com.devjava.CadastroDeUsuarios.Usuario;


import com.devjava.CadastroDeUsuarios.Carros.CarrosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "idade")
    private int idade;


    //@ManyToOne um usuário so pode ter um unico carro
    @ManyToOne
    @JoinColumn(name = "carros_id")  //chave estrangeira
    private CarrosModel carros;

}
