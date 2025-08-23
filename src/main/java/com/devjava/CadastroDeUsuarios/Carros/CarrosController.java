package com.devjava.CadastroDeUsuarios.Carros;


import com.devjava.CadastroDeUsuarios.Usuario.UsuarioModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarrosController {

    private CarrosService carrosService;

    // POST -- Mandar uma requisição para criar os carros
    //Adicionar carro
    @PostMapping("/criar")
    public CarrosModel criarCarro(@RequestBody CarrosModel carro){
        return carrosService.criarCarro(carro);
    }

    // GET - MAndar uma requisição para mostrar os carros
    //Mostrar carro
    @GetMapping("/listar")
    public List<CarrosModel> listarCarros(){
        return carrosService.listarCarros();
    }

    //Mostrar carro por ID   (READ)
    @GetMapping("/listar/{id}")
    public CarrosModel listarCarroPorId(@PathVariable Long id){
        return carrosService.listarCarroPorID(id);
    }

    // PUT -- Manda um requisição para alaterar os carros
    //Alterar dados dos carros por id
    @PutMapping("/alterar/{id}")
    public CarrosModel alterarcarroPorId(@PathVariable Long id, @RequestBody CarrosModel carroAtualizado){
        return carrosService.atualizarCarro(id,carroAtualizado);
    }


    // DELETE -- Manda um requisição para deletar os carros
    //Deletar carro por id
    @DeleteMapping("/deletar/{id}")
    public void deletaCarroPorId(@PathVariable Long id){
        carrosService.deletarCarrooPorId(id);
    }

}
