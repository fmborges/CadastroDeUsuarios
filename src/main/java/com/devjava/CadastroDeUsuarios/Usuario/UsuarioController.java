package com.devjava.CadastroDeUsuarios.Usuario;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Bem Vindo!";
    }

    //Adicionar usuário  (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarUsuario(@RequestBody UsuarioDTO usuario){
        UsuarioDTO novoUsuario = usuarioService.criarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuário criado com sucesso: " + novoUsuario.getNome() + "(ID): " + novoUsuario.getId());

    }

    //Mostra todos usuários (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios(){
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    //Mostrar Usuários por ID   (READ)
    @GetMapping("/listar/{id}")
    //Foi coloca ? para ser um Generics e o retorno possa devolver Json
    public ResponseEntity<?> listarUsuarioPorId(@PathVariable Long id){

        UsuarioDTO usuario = usuarioService.listarUsuarioPorID(id);
        if (usuarioService.listarUsuarioPorID(id) != null){

            return ResponseEntity.ok(usuario);

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário com ID: " + id + " não foi encontrado");
        }
    }


    //Alterar dados dos usuários  (UPDATE)
    @PutMapping("/alterar/{ID}")
    public ResponseEntity<?> alterarUsuarioPorId(@PathVariable Long id, @RequestBody UsuarioDTO usuarioAtualizado) {

        UsuarioDTO usuario = usuarioService.atualizarUsuario(id, usuarioAtualizado);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário com ID " + id + " não encontrado");
        }
    }


    //Deletar usuário    (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletaUsuarioPorId(@PathVariable Long id){
        //Se a lista do usuário service passage pelo ID não for null
        if (usuarioService.listarUsuarioPorID(id) != null){
            usuarioService.deletarUsuarioPorId(id);
            return ResponseEntity.ok("Usuário com ID: " + id + " deletado com sucesso ");

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário com ID: " + id + " não foi encontrado");
        }


    }
}
