package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Propietario;

@Repository
public class PropietarioRepoImpl implements IPropietarioRepo{
	
	private static List<Propietario> base = new ArrayList<Propietario>();

	@Override
	public Propietario seleccionar(String cedula) {
		for (Propietario propietario : base) {
			if (propietario.getCedula().equals(cedula)) {
				Propietario pro = new Propietario();
				pro.setApellido(propietario.getApellido());
				pro.setCedula(propietario.getCedula());
				pro.setGenero(propietario.getGenero());
				pro.setNombre(propietario.getNombre());
				return pro;
			}
		}
		System.out.println("Propietario No Existe");
		return null;
	}

	@Override
	public void insertar(Propietario propietario) {
		base.add(propietario);
		
	}

	@Override
	public void eliminar(String cedula) {
		Propietario pro = this.seleccionar(cedula);
		base.remove(pro);
		
	}

	@Override
	public void actualizar(Propietario propietario) {
		this.eliminar(propietario.getCedula());
		this.insertar(propietario);
		
	}

}
