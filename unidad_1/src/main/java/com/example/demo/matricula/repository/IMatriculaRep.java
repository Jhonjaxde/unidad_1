package com.example.demo.matricula.repository;

import java.util.List;

import com.example.demo.matricula.repository.modelo.Matricula;



public interface IMatriculaRep {

	public Matricula seleccionar(String codigo);

	public void insertar(Matricula matricula);

	public void actualizar(Matricula matricula);

	public void eliminar(String codigo);
	
	public List<Matricula> reporte();


}
