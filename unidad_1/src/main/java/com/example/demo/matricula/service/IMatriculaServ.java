package com.example.demo.matricula.service;

import java.util.List;

import com.example.demo.matricula.repository.modelo.Matricula;



public interface IMatriculaServ {
	
	public Matricula buscar(String codigo);

	public void guardar(Matricula matricula);

	public void actualizar(Matricula matricula);

	public void eliminar(String codigo);
	
	public void matricula(String cedula, String placa);
	
	public List<Matricula> buscarTodo();

}