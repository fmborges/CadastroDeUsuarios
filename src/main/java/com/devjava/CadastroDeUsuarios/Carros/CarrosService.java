package com.devjava.CadastroDeUsuarios.Carros;

import com.devjava.CadastroDeUsuarios.Usuario.UsuarioDTO;
import com.devjava.CadastroDeUsuarios.Usuario.UsuarioMapper;
import com.devjava.CadastroDeUsuarios.Usuario.UsuarioModel;
import com.devjava.CadastroDeUsuarios.Usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CarrosService {
    private CarrosRepository carrosRepository;
    private CarrosMapper carrosMapper;


    public CarrosService(CarrosRepository carrosRepository, CarrosMapper carrosMapper) {
        this.carrosRepository = carrosRepository;
        this.carrosMapper = carrosMapper;
    }

    //Listar todos carros
    public List<CarrosModel> listarcarros(){
        return carrosRepository.findAll();
    }

    //Lista carro por ID
    public CarrosModel listarCarroPorID(long id){
        //caso não possua carro no ID informado
        Optional<CarrosModel> carroPorId = carrosRepository.findById(id);
        return carroPorId.orElse(null);
    }

    //Criar um novo carro
    public CarrosDTO criarcarro(CarrosDTO carrosDTO){
        CarrosModel carro = carrosMapper.map(carrosDTO);
        carro = carrosRepository.save(carro);
        return carrosMapper.map(carro);
    }

    //Deletar carro - tem que ser um metodo VOID
    public void  deletarCarroPorId(Long id){
        carrosRepository.deleteById(id);
    }

    //Atualizar carro
    public CarrosModel atualizarCarro(Long id,CarrosModel carroAtualizado){
        if (carrosRepository.existsById(id)) {
            carroAtualizado.setId(id);
            return carrosRepository.save(carroAtualizado);
        }
        return null;
    }
}
