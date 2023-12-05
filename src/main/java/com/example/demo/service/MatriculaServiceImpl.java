package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMatriculaRepo;
import com.example.demo.repository.IPropietarioRepo;
import com.example.demo.repository.IVehiculoRepo;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.repository.modelo.Vehiculo;

@Service
public class MatriculaServiceImpl implements IMatriculaService{	
	
	@Autowired
	private IMatriculaRepo iMatriculaRepo;

	@Autowired
	private IVehiculoRepo iVehiculoRepo;

	@Autowired
	private IPropietarioRepo iPropietarioRepo;

	@Override
	public void guardar(Matricula matricula) {
		this.iMatriculaRepo.insertar(matricula);
	}

	
	@Override
	public Matricula buscar(String codigo) {
		// TODO Auto-generated method stub
		return this.iMatriculaRepo.seleccionar(codigo);
	}

	@Override
	public void registrar(String identificacion, String placa) {
		Vehiculo vehi = this.iVehiculoRepo.seleccionar(placa);
		Propietario pro = this.iPropietarioRepo.seleccionar(identificacion);

		Matricula matri = new Matricula();
		matri.setCodigo("Matri1");
		matri.setFechaMatricula(LocalDateTime.now());
		matri.setValorMatricula(new BigDecimal(3001));
		matri.setPropietario(pro);		
		matri.setVehiculo(vehi);

		BigDecimal valorLimite = new BigDecimal(2200);	
		

		if (matri.getValorMatricula().compareTo(valorLimite) > 0) {
			BigDecimal descuento = matri.getValorMatricula().multiply(new BigDecimal(0.05));
			matri.setValorMatricula(matri.getValorMatricula().subtract(descuento));
			if (vehi.getTipo().equals("pesado")) {
				BigDecimal nuevoValorMatricula = matri.getValorMatricula().multiply(new BigDecimal(0.25));
				matri.setValorMatricula(nuevoValorMatricula);
				this.iMatriculaRepo.insertar(matri);
			} else {
				BigDecimal nuevoValorMatricula = matri.getValorMatricula().multiply(new BigDecimal(0.2));
				matri.setValorMatricula(nuevoValorMatricula);
				this.iMatriculaRepo.insertar(matri);
			}
		} else {
			
			System.out.println("MATRICULA SIN DESCUENTO");
			if (vehi.getTipo().equals("pesado")) {
				BigDecimal nuevoValorMatricula = matri.getValorMatricula().multiply(new BigDecimal(0.25));
				matri.setValorMatricula(nuevoValorMatricula);
				this.iMatriculaRepo.insertar(matri);
			} else {
				BigDecimal nuevoValorMatricula = matri.getValorMatricula().multiply(new BigDecimal(0.2));
				matri.setValorMatricula(nuevoValorMatricula);
				this.iMatriculaRepo.insertar(matri);
			}
		}

	}

}
