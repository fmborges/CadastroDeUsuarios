package com.devjava.CadastroDeUsuarios.Usuario;

import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {


    public UsuarioModel map(UsuarioDTO usuarioDTO){
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setId(usuarioDTO.getId());
        usuarioModel.setNome(usuarioDTO.getNome());
        usuarioModel.setEmail(usuarioDTO.getEmail());
        usuarioModel.setIdade(usuarioDTO.getIdade());
        usuarioModel.setCarros(usuarioDTO.getCarros());

        return usuarioModel;
    }
    public UsuarioDTO map(UsuarioModel usuarioModel) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuarioModel.getId());
        usuarioDTO.setNome(usuarioModel.getNome());
        usuarioDTO.setEmail(usuarioModel.getEmail());
        usuarioDTO.setIdade(usuarioModel.getIdade());
        usuarioDTO.setCarros(usuarioModel.getCarros());

        return usuarioDTO;
    }



}
