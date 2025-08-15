package com.devjava.CadastroDeUsuarios.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {


    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //Listar todos usuário
    public List<UsuarioModel> listarUsuarios(){
        return usuarioRepository.findAll();
    }








}
