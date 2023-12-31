package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Matricula;

@Repository
public class MatriculaRepoImpl implements IMatriculaRepo{
	
	private static List<Matricula> base = new ArrayList<Matricula>();

	@Override
	public Matricula seleccionar(String codigo) {
		for (Matricula matricula : base) {
			if (matricula.getCodigo().equals(codigo)) {
				Matricula matri = new Matricula();
				matri.setCodigo(matricula.getCodigo());
				matri.setFechaMatricula(matricula.getFechaMatricula());
				matri.setPropietario(matricula.getPropietario());
				matri.setValorMatricula(matricula.getValorMatricula());
				matri.setVehiculo(matricula.getVehiculo());
				
				return matri;
			}
		}
		System.out.println("Propietario No Existe");
		return null;
	}

	@Override
	public void insertar(Matricula matricular) {
		base.add(matricular);
		
	}

}
