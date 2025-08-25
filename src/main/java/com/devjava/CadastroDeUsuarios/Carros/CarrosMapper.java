package com.devjava.CadastroDeUsuarios.Carros;


public class CarrosMapper {


    public CarrosModel map(CarrosDTO carrosDTO) {
        CarrosModel carrosModel = new CarrosModel();
        carrosModel.setId(carrosDTO.getId());
        carrosModel.setNomeDoCarro(carrosDTO.getNomeDoCarro());
        carrosModel.setMarcaDoCarro(carrosDTO.getMarcaDoCarro());
        carrosModel.setCambio(carrosDTO.getCambio());
        carrosModel.setUsuarios(carrosDTO.getUsuarios());

        return carrosModel;
    }
    public CarrosDTO map(CarrosModel carrosModel) {
        CarrosDTO carrosDTO = new CarrosDTO();
        carrosDTO.setId(carrosModel.getId());
        carrosDTO.setNomeDoCarro(carrosModel.getNomeDoCarro());
        carrosDTO.setMarcaDoCarro(carrosModel.getMarcaDoCarro());
        carrosDTO.setCambio(carrosModel.getCambio());
        carrosDTO.setUsuarios(carrosModel.getUsuarios());

        return carrosDTO;
    }

}
