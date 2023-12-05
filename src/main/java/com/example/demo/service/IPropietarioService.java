package com.example.demo.service;

import com.example.demo.repository.modelo.Propietario;

public interface IPropietarioService {
	
	public Propietario buscar (String cedula);
	public void guardar (Propietario propietario);
	public void quitar (String cedula);
	public void modificar (Propietario propietario);

}
