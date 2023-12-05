package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.IMatriculaRepo;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.IMatriculaService;
import com.example.demo.service.IPropietarioService;
import com.example.demo.service.IVehiculoService;

@SpringBootApplication
public class EjercicioPaU1P5CbApplication implements CommandLineRunner {
	
	@Autowired
	private IVehiculoService iVehiculoService;
	
	@Autowired
	private IPropietarioService iPropietarioService;
	
	@Autowired 
	private IMatriculaService iMatriculaService;

	public static void main(String[] args) {
		SpringApplication.run(EjercicioPaU1P5CbApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		
		
				
		Vehiculo vehi = new Vehiculo();
		vehi.setMarca("KIA");
		vehi.setPlaca("PCK6693");
		vehi.setPrecio(new BigDecimal(25000));
		vehi.setTipo("liviano");
		this.iVehiculoService.guardar(vehi);		
		System.out.println(this.iVehiculoService.buscar("PCK6693"));
		
		
		Propietario pro = new Propietario ();
		pro.setApellido("Betancourt");
		pro.setCedula("1722781000");
		pro.setGenero("Masculino");
		pro.setNombre("Christian");
		this.iPropietarioService.guardar(pro);
		
		pro.setApellido("Alban");
		pro.setNombre("Alejandro");
		this.iPropietarioService.modificar(pro);
		
		
		this.iMatriculaService.registrar("1722781000", "PCK6693");
		System.out.println(this.iMatriculaService.buscar("Matri1"));
		
		
		
		
		
		
		
		
		
		
	}

}
