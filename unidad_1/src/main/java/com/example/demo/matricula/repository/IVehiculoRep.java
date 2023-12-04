package com.example.demo.matricula.repository;

import com.example.demo.matricula.repository.modelo.Vehiculo;

public interface IVehiculoRep {

	public Vehiculo seleccionar(String placa);

	public void insertar(Vehiculo vehiculo);

	public void actualizar(Vehiculo vehiculo);

	public void eliminar(String placa);

}