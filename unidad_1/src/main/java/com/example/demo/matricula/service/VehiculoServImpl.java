package com.example.demo.matricula.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.matricula.repository.IVehiculoRep;
import com.example.demo.matricula.repository.modelo.Vehiculo;



@Service
public class VehiculoServImpl implements IVehiculoServ {
	
	
	@Autowired
	private IVehiculoRep vehiculoRep;

	@Override
	public Vehiculo buscar(String placa) {
		// TODO Auto-generated method stub
		return this.vehiculoRep.seleccionar(placa);
	}

	@Override
	public void guardar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.vehiculoRep.insertar(vehiculo);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.vehiculoRep.actualizar(vehiculo);
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		this.vehiculoRep.eliminar(placa);
	}

}