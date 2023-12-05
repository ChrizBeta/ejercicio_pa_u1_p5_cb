package com.example.demo.repository;

import com.example.demo.repository.modelo.Matricula;

public interface IMatriculaRepo {
	
	public Matricula seleccionar (String codigo);
	public void insertar (Matricula matricular);

}
