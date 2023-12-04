package com.example.demo.matricula.repository;

import com.example.demo.matricula.repository.modelo.Propietario;

public interface IPropietarioRep {

	public Propietario seleccionar(String cedula);

	public void insertar(Propietario propietario);

	public void actulizar(Propietario propietario);

	public void eliminar(String cedula);

}