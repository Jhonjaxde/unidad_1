package com.example.demo.matricula.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.matricula.repository.modelo.Propietario;



@Repository
public class PropietarioRepImpl implements IPropietarioRep {

	private static List<Propietario> base = new ArrayList<>();

	@Override
	public Propietario seleccionar(String cedula) {
		// TODO Auto-generated method stub
		for (Propietario propietario : base) {
			if (propietario.getCedula().equals(cedula)) {

				Propietario p = new Propietario();
				p.setNombre(propietario.getNombre());
				p.setApellido(propietario.getApellido());
				p.setCedula(propietario.getCedula());
				p.setFechaNacimiento(propietario.getFechaNacimiento());

				return propietario;
			}
		}
		return null;
	}

	@Override
	public void insertar(Propietario propietario) {
		// TODO Auto-generated method stub
		base.add(propietario);

	}

	@Override
	public void actulizar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.eliminar(propietario.getCedula());
		this.insertar(propietario);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		Propietario p = this.seleccionar(cedula);
		base.remove(p);
	}

}
