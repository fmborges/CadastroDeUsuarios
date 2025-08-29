package com.devjava.CadastroDeUsuarios.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    //Listar todos usuário
    public List<UsuarioDTO> listarUsuarios(){
        List<UsuarioModel> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuarioMapper::map)
                .collect(Collectors.toList());
    }

    //Lista usuário por ID
    public UsuarioDTO listarUsuarioPorID(long id){
        //caso não possua usuário no ID informado
        Optional<UsuarioModel> usuarioPorId = usuarioRepository.findById(id);
        return usuarioPorId.map(usuarioMapper::map).orElse(null);
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
    public UsuarioDTO atualizarUsuario(Long id,UsuarioDTO usuarioDTO){
        Optional<UsuarioModel> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            UsuarioModel usuarioAtualizado = usuarioMapper.map(usuarioDTO);
            usuarioAtualizado.setId(id);
            UsuarioModel usuarioSalvo =usuarioRepository.save(usuarioAtualizado);
            return usuarioMapper.map(usuarioSalvo);
        }
        return null;
    }
}
