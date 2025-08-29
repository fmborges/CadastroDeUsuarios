package com.devjava.CadastroDeUsuarios.Carros;


import com.devjava.CadastroDeUsuarios.Usuario.UsuarioDTO;
import com.devjava.CadastroDeUsuarios.Usuario.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("missoes")
public class CarrosController {

    private final CarrosService carrosService;

    public CarrosController(CarrosService carrosService) {
        this.carrosService = carrosService;
    }

    // POST -- Mandar uma requisição para criar os carros
    //Adicionar carro
    @PostMapping("/criar")
    public ResponseEntity<String> criarCrarro(@RequestBody CarrosDTO carro){
        CarrosDTO novoCarro = carrosService.criarcarro(carro);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Carro criado com Sucesso " + novoCarro.getNomeDoCarro() + "ID: " + novoCarro.getId());
    }

    // GET - MAndar uma requisição para mostrar os carros
    //Mostrar carro
    @GetMapping("/listar")
    public ResponseEntity<List<CarrosDTO>> listarCarros(){
        List<CarrosDTO> carros = carrosService.listarcarros();
        return ResponseEntity.ok(carros);
    }

    // PUT -- Manda um requisição para alaterar os carros
    //Alterar dados dos carros
    @PutMapping("/alterar/{ID}")
    public ResponseEntity<?> alterarCrarroPorId(@PathVariable Long id, @RequestBody CarrosDTO carroAtualizado){
        CarrosDTO carro = carrosService.atualizarCarro(id, carroAtualizado);
        if (carro != null) {
            return ResponseEntity.ok(carro);

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Carro com ID " + id + " não encontrado");
        }

    }


    // DELETE -- Manda um requisição para deletar os carros
    //Deletar carro
    @DeleteMapping("/deletar/{ID}")
    public ResponseEntity<String> deletaCarroPorId(@PathVariable Long id){
        //Se a lista do carro service passage pelo ID não for null
        if (carrosService.listarCarroPorID(id) != null){
            carrosService.deletarCarroPorId(id);
            return ResponseEntity.ok("Carro com ID: " + id + " deletado com sucesso ");

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Carro com ID: " + id + " não foi encontrado");
        }


    }

}
