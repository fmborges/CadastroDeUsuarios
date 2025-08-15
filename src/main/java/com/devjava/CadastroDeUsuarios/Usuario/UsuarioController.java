package com.devjava.CadastroDeUsuarios.Usuario;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem!";
    }

    //Adicionar usuário  (CREATE)
    @PostMapping("/criar")
    public String criarUsuario(){
        return "Usuário Criado";

    }

    //Mostra todos usuários (READ)
    @GetMapping("/listar")
    public List<UsuarioModel> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    //Mostrar Usuários por ID   (READ)
    @GetMapping("/listarID")
    public String mostrarUsuarioID(){
        return "Mostrar usuários por ID";
    }


    //Alterar dados dos usuários  (UPDATE)
    @PutMapping("/alterarID")
    public String alterarUsuarioPorId(){
        return "Alerar usuário por ID";
    }


    //Deletar usuário    (DELETE)
    @DeleteMapping("/deletarID")
    public String deletaUsuarioPorId(){
        return "Usuário deletado por ID";
    }

}
