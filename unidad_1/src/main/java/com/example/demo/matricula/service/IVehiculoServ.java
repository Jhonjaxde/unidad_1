package com.example.demo.matricula.service;

import com.example.demo.matricula.repository.modelo.Vehiculo;

public interface IVehiculoServ {

	public Vehiculo buscar(String placa);

	public void guardar(Vehiculo vehiculo);

	public void actualizar(Vehiculo vehiculo);

	public void eliminar(String placa);

}