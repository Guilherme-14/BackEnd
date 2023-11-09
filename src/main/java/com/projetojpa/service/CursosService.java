package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Cursos;
import com.projetojpa.repository.CursosRepository;

@Service
public class CursosService {

	private final CursosRepository cursosRepository;
	
	@Autowired
	public CursosService(CursosRepository cursosRepository) {
		this.cursosRepository = cursosRepository;
	}
	
	public List<Cursos> buscaTodosCursos(){
		return cursosRepository.findAll();
	}
	
	public Cursos BuscaCursosId(Long id) {
		Optional <Cursos> Cursos = cursosRepository.findById(id);
		return Cursos.orElse(null);
	}
	
	public Cursos salvaCursos (Cursos cursos) {
		return cursosRepository.save(cursos);	
	}
	
	public Cursos alterarCursos (Long id, Cursos alterarC) {
		Optional <Cursos> existeCursos = cursosRepository.findById(id);
		if (existeCursos.isPresent()) {
			alterarC.setId(id);
			return cursosRepository.save(alterarC);
		}
		return null;
	}
	
	public boolean apagarCursos(Long id) {
		Optional <Cursos> existeCursos = cursosRepository.findById(id);
		if (existeCursos.isPresent()) {
			cursosRepository.deleteById(id);
			return true;
		}
		return false;
	}


}
