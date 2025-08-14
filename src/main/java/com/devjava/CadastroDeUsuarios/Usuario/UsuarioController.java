package com.devjava.CadastroDeUsuarios.Usuario;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UsuarioController {

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
    @GetMapping("/todos")
    public String mostrarTodosUsuaris(){
        return "Mostrar todos os usuários";
    }


    //Mostrar Usuários por ID   (READ)
    @GetMapping("/todosID")
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
