package com.example.demo.service;

import com.example.demo.repository.modelo.Matricula;

public interface IMatriculaService {
	
	public Matricula buscar (String codigo);
	public void guardar (Matricula matricular);
	
	public void registrar (String identificacion, String placa);

}
