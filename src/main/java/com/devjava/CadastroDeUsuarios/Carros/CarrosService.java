package com.devjava.CadastroDeUsuarios.Carros;

import com.devjava.CadastroDeUsuarios.Usuario.UsuarioModel;
import com.devjava.CadastroDeUsuarios.Usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrosService {

    private CarrosRepository carrosRepository;

    public CarrosService(CarrosRepository carrosRepository) {
        this.carrosRepository = carrosRepository;
    }


    //Listar todos usuário
    public List<CarrosModel> listarCarros(){
        return carrosRepository.findAll();
    }

    //Lista carro por ID
    public CarrosModel listarCarroPorID(long id){
        //caso não possua usuário no ID informado
        Optional<CarrosModel> carroPorId = carrosRepository.findById(id);
        return carroPorId.orElse(null);
    }

    //Criar um novo carro
    public CarrosModel criarCarro(CarrosModel carro){
        return carrosRepository.save(carro);
    }

    //Deletar carro - tem que ser um metodo VOID
    public void  deletarCarrooPorId(Long id){
        carrosRepository.deleteById(id);
    }

    //Atualizar usuario
    public CarrosModel atualizarCarro(Long id,CarrosModel carroAtualizado) {
        if (carrosRepository.existsById(id)) {
            carroAtualizado.setId(id);
            return carrosRepository.save(carroAtualizado);
        }
        return null;
    }
}
