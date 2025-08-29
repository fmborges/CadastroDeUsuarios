package com.devjava.CadastroDeUsuarios.Carros;

import com.devjava.CadastroDeUsuarios.Usuario.UsuarioDTO;
import com.devjava.CadastroDeUsuarios.Usuario.UsuarioMapper;
import com.devjava.CadastroDeUsuarios.Usuario.UsuarioModel;
import com.devjava.CadastroDeUsuarios.Usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CarrosService {
    private CarrosRepository carrosRepository;
    private CarrosMapper carrosMapper;


    public CarrosService(CarrosRepository carrosRepository, CarrosMapper carrosMapper) {
        this.carrosRepository = carrosRepository;
        this.carrosMapper = carrosMapper;
    }

    //Listar todos carros
    public List<CarrosDTO> listarcarros(){
        List<CarrosModel> carros = carrosRepository.findAll();
        return carros.stream()
                .map(carrosMapper::map)
                .collect(Collectors.toList());
    }

    //Lista carro por ID
    public CarrosDTO listarCarroPorID(long id){
        //caso não possua carro no ID informado
        Optional<CarrosModel> carroPorId = carrosRepository.findById(id);
        return carroPorId.map(carrosMapper::map).orElse(null);
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
    public CarrosDTO atualizarCarro(Long id,CarrosDTO carrosDTO){
        Optional<CarrosModel> carroExistente = carrosRepository.findById(id);
        if (carroExistente.isPresent()) {
            CarrosModel carroAtualizado = carrosMapper.map(carrosDTO);
            carroAtualizado.setId(id);
            CarrosModel carroSalvo = carrosRepository.save(carroAtualizado);
            return carrosMapper.map(carroSalvo);
        }
        return null;
    }
}
