package com.example.demo.matricula.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.matricula.repository.IMatriculaRep;
import com.example.demo.matricula.repository.IPropietarioRep;
import com.example.demo.matricula.repository.IVehiculoRep;
import com.example.demo.matricula.repository.modelo.Matricula;
import com.example.demo.matricula.repository.modelo.Propietario;
import com.example.demo.matricula.repository.modelo.Vehiculo;

@Service
public class MatriculaServImpl implements IMatriculaServ {

	@Autowired
	private IMatriculaRep matriculaRep;
	@Autowired
	private IPropietarioRep propietarioRep;
	@Autowired
	private IVehiculoRep vehiculoRep;

	@Override
	public Matricula buscar(String codigo) {
		// TODO Auto-generated method stub
		return this.matriculaRep.seleccionar(codigo);
	}

	@Override
	public void guardar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.matriculaRep.insertar(matricula);
	}

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.matriculaRep.actualizar(matricula);

	}

	@Override
	public void eliminar(String codigo) {
		// TODO Auto-generated method stub
		this.matriculaRep.eliminar(codigo);
	}

	@Override
	public void matricula(String cedula, String placa) {
		// TODO Auto-generated method stub
		Propietario p=this.propietarioRep.seleccionar(cedula);
		Vehiculo v = this.vehiculoRep.seleccionar(placa);
		BigDecimal precio= v.getPrecio();
		if (precio.compareTo(new BigDecimal(2000))>0) {
			
			BigDecimal descuento = precio.multiply(new BigDecimal(0.07));
			BigDecimal nuevoValorFinal = precio.subtract(descuento);
			v.setPrecio(nuevoValorFinal);
			this.vehiculoRep.actualizar(v);
			
		}
		
		if (v.getTipo().toLowerCase().contains("pesado")) {
			BigDecimal valorF= v.getPrecio().multiply(new BigDecimal(0.15));
			v.setPrecio(valorF);
			this.vehiculoRep.actualizar(v);
			
		}else if(v.getTipo().toLowerCase().contains("liviano")) {
			BigDecimal valorF= v.getPrecio().multiply(new BigDecimal(0.10));
			v.setPrecio(valorF);
			this.vehiculoRep.actualizar(v);
		}
		
		Matricula matricula = new Matricula();
		matricula.setCodigo("m1");
		matricula.setFechaMatricula(LocalDateTime.now());
		matricula.setValorMatricula(v.getPrecio());
		matricula.setPropietario(p);
		matricula.setVehiculo(v);
		this.matriculaRep.insertar(matricula);
		
		
	}

	@Override
	public List<Matricula> buscarTodo() {
		// TODO Auto-generated method stub
		return this.matriculaRep.reporte();
	}

}