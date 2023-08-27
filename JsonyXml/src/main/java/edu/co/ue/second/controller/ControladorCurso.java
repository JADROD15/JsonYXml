package edu.co.ue.second.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.co.ue.second.model.Curso;

@RestController
public class ControladorCurso {
	
	Curso curso;
	
	@PostConstruct
	public void init() {
		curso = new Curso();
	}
	
	@GetMapping(value="cursos", produces=MediaType.APPLICATION_XML_VALUE)
	public List<Curso> getCursos(){
		return curso.myListCursos();
	}
	
	@GetMapping(value="cursos/{name}", produces=MediaType.APPLICATION_XML_VALUE)
	public List<Curso> buscarCursos(@PathVariable("name") String nam){
		return curso.buscarCursos(nam);
	}
	
	@GetMapping(value="curso", produces=MediaType.APPLICATION_XML_VALUE)
	public Curso getCurso() {
		return new Curso("JavaScript",20.0,10.0,24);
	}
	
	@DeleteMapping(value="curso/{name}")
	public List<Curso> deleteCurso(@PathVariable("name") String name) {
		return curso.deleteCurso(name);
	}
	
	@PostMapping(value="curso", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_XML_VALUE)
	public List<Curso> postCurso(@RequestBody Curso c) {
		return curso.postCurso(c);
	}
	
	@PutMapping(value = "cursos/{name}", consumes = MediaType.APPLICATION_XML_VALUE)
    public List<Curso> putCurso(@PathVariable("name") String name, @RequestBody Curso cursoToUpdate) {
        List<Curso> cursos = curso.myListCursos();

        for (Curso curso : cursos) {
            if (curso.getName().equals(name)) {
                curso.setName(cursoToUpdate.getName());
                curso.setDuration(cursoToUpdate.getDuration());
                curso.setCost(cursoToUpdate.getCost());
                curso.setAbility(cursoToUpdate.getAbility());
                break;
            }
        }

        return cursos; 
    }
	
}
