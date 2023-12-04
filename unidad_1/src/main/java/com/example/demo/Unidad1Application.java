package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.matricula.repository.modelo.Propietario;
import com.example.demo.matricula.repository.modelo.Vehiculo;
import com.example.demo.matricula.service.IMatriculaServ;
import com.example.demo.matricula.service.IPropietarioServ;
import com.example.demo.matricula.service.IVehiculoServ;

@SpringBootApplication
public class Unidad1Application implements CommandLineRunner{
	@Autowired
	private IVehiculoServ vehiculoServ;
	@Autowired
	private IPropietarioServ propietarioServ;
	@Autowired
	private IMatriculaServ matriculaServ;
	public static void main(String[] args) {
		SpringApplication.run(Unidad1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hola mundo");
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMarca("chevlolet");
		vehiculo.setPlaca("1");
		vehiculo.setPrecio(new BigDecimal(200));
		vehiculo.setTipo("pesado");
		
		this.vehiculoServ.guardar(vehiculo);
		
		Propietario p = new Propietario();
		p.setApellido("hermenegildo");
		p.setCedula("2");
		p.setFechaNacimiento(LocalDateTime.now());
		p.setNombre("juan");
		
		this.propietarioServ.guardar(p);
		
		this.matriculaServ.matricula("2", "1");
		System.out.println(this.matriculaServ.buscar("m1"));
		
		
	}

}
