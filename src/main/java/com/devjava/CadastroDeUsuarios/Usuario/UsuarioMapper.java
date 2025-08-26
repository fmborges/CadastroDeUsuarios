package com.devjava.CadastroDeUsuarios.Usuario;

import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioModel map(UsuarioDTO usuarioDTO){

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setId(usuarioDTO.getId());
        usuarioModel.setNome(usuarioDTO.getNome());
        usuarioModel.setIdade(usuarioDTO.getIdade());
        usuarioModel.setEmail(usuarioDTO.getEmail());
        usuarioModel.setCarros(usuarioDTO.getCarros());

        return usuarioModel;

    }

    public UsuarioDTO map(UsuarioModel usuarioModel) {

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuarioModel.getId());
        usuarioDTO.setNome(usuarioModel.getNome());
        usuarioDTO.setIdade(usuarioModel.getIdade());
        usuarioDTO.setEmail(usuarioModel.getEmail());
        usuarioDTO.setCarros(usuarioModel.getCarros());

        return usuarioDTO;

    }

}

