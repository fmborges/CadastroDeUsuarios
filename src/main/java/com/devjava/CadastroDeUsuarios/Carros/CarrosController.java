package com.devjava.CadastroDeUsuarios.Carros;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class CarrosController {


    // POST -- Mandar uma requisição para criar os carros
    //Adicionar carro
    @PostMapping("/criar")
    public String criarCrarro(){
        return "Carro criado com sucesso";
    }

    // GET - MAndar uma requisição para mostrar os carros
    //Mostrar carro
    @GetMapping("/listar")
    public String listarCarros(){
        return "Lista de carros";
    }

    // PUT -- Manda um requisição para alaterar os carros
    //Alterar dados dos carros
    @PutMapping("/alterar")
    public String alterarCrarro(){
        return "Carro alterado com sucesso";
    }


    // DELETE -- Manda um requisição para deletar os carros
    //Deletar carro
    @DeleteMapping("/deletar")
    public String deletarCarro(){
        return "Carro deletado com sucesso";
    }

}
