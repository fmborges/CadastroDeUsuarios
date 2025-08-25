package com.devjava.CadastroDeUsuarios.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {


    private UsuarioRepository usuarioRepository;
    private UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    //Listar todos usuário
    public List<UsuarioModel> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    //Lista usuário pot ID
    public UsuarioModel listarUsuarioPorID(long id){
        //caso não possua usuário no ID informado
        Optional<UsuarioModel> usuarioPorId = usuarioRepository.findById(id);
        return usuarioPorId.orElse(null);
    }

    //Criar um novo usuário
    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO){
        UsuarioModel usuario = usuarioMapper.map(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.map(usuario);
    }

    //Deletar usuario - tem que ser um metodo VOID
    public void  deletarUsuarioPorId(Long id){
        usuarioRepository.deleteById(id);
    }

    //Atualizar usuario
    public UsuarioModel atualizarUsuario(Long id,UsuarioModel usuarioAtualizado){
        if (usuarioRepository.existsById(id)) {
            usuarioAtualizado.setId(id);
            return usuarioRepository.save(usuarioAtualizado);
        }
        return null;
    }
}
