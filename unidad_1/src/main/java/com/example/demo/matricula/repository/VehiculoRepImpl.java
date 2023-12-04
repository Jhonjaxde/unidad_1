package com.example.demo.matricula.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.matricula.repository.modelo.Vehiculo;



@Repository
public class VehiculoRepImpl implements IVehiculoRep {

	private static List<Vehiculo> base = new ArrayList<>();

	@Override
	public Vehiculo seleccionar(String placa) {
		// TODO Auto-generated method stub
		for (Vehiculo vehiculo : base) {
			if (vehiculo.getPlaca().equals(placa)) {

				Vehiculo v = new Vehiculo();
				v.setMarca(vehiculo.getMarca());
				v.setPlaca(vehiculo.getPlaca());
				v.setPrecio(vehiculo.getPrecio());
				v.setTipo(vehiculo.getTipo());

				return vehiculo;
			}
		}
		return null;
	}

	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		base.add(vehiculo);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub

		this.eliminar(vehiculo.getPlaca());
		this.insertar(vehiculo);

	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		Vehiculo ve = this.seleccionar(placa);
		base.remove(ve);
	}

}