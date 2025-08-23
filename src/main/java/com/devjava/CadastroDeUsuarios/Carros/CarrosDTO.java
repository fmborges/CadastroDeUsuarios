package com.devjava.CadastroDeUsuarios.Carros;


import com.devjava.CadastroDeUsuarios.Usuario.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarrosDTO {

    private Long id;
    private String nomeDoCarro;
    private String marcaDoCarro;
    private String cambio;
    private List<UsuarioModel> usuarios;

}
