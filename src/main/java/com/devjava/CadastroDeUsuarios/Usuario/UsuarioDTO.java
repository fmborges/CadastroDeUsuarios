package com.devjava.CadastroDeUsuarios.Usuario;

import com.devjava.CadastroDeUsuarios.Carros.CarrosModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Long id;

    private String nome;

    private String email;

    private int idade;

    private CarrosModel carros;

}
