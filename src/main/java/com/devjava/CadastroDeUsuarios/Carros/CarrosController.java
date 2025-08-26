package com.devjava.CadastroDeUsuarios.Carros;


import com.devjava.CadastroDeUsuarios.Usuario.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class CarrosController {

    private CarrosService carrosService;

    public CarrosController(CarrosService carrosService) {
        this.carrosService = carrosService;
    }

    // POST -- Mandar uma requisição para criar os carros
    //Adicionar carro
    @PostMapping("/criar")
    public CarrosDTO criarCrarro(@RequestBody CarrosDTO carro){
        return carrosService.criarcarro(carro);
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
