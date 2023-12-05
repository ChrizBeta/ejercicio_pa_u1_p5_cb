package com.example.demo.repository;

import com.example.demo.repository.modelo.Propietario;

public interface IPropietarioRepo {
	
	public Propietario seleccionar (String cedula);
	public void insertar (Propietario propietario);
	public void eliminar (String cedula);
	public void actualizar (Propietario propietario);

}
