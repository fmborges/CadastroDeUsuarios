package com.devjava.CadastroDeUsuarios.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //lista usuário pot ID
    public UsuarioModel listarUsuarioPorID(long id){
        //caso não possua usuário no ID informado
        Optional<UsuarioModel> usuarioPorId = usuarioRepository.findById(id);
        return usuarioPorId.orElse(null);
    }







}
