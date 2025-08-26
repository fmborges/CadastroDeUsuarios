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
    public UsuarioDTO criarUsuario(@RequestBody UsuarioDTO usuario){
        return usuarioService.criarUsuario(usuario);

    }

    //Mostra todos usuários (READ)
    @GetMapping("/listar")
    public List<UsuarioDTO> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    //Mostrar Usuários por ID   (READ)
    @GetMapping("/listar/{id}")
    public UsuarioDTO listarUsuarioPorId(@PathVariable Long id){
        return usuarioService.listarUsuarioPorID(id);
    }


    //Alterar dados dos usuários  (UPDATE)
    @PutMapping("/alterar/{ID}")
    public UsuarioDTO alterarUsuarioPorId(@PathVariable Long id, @RequestBody UsuarioDTO usuarioAtualizado){
        return usuarioService.atualizarUsuario(id, usuarioAtualizado);
    }


    //Deletar usuário    (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletaUsuarioPorId(@PathVariable Long id){
        usuarioService.deletarUsuarioPorId(id);
    }

}
