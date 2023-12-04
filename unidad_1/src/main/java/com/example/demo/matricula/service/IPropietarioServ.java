package com.example.demo.matricula.service;

import com.example.demo.matricula.repository.modelo.Propietario;

public interface IPropietarioServ {

	public Propietario buscar(String cedula);

	public void guardar(Propietario propietario);

	public void actulizar(Propietario propietario);

	public void eliminar(String cedula);

}
