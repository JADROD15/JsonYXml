package edu.co.ue.second.model;

import java.util.ArrayList;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class Curso {
	private String name;
	private double duration;
	private double cost;
	private int ability;
	private ArrayList<Curso> cursos;
	
	
	public Curso(String name, double duration, double cost, int ability) {
		super();
		this.name = name;
		this.duration = duration;
		this.cost = cost;
		this.ability = ability;
	}
	public Curso() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getAbility() {
		return ability;
	}
	public void setAbility(int ability) {
		this.ability = ability;
	}
	
	public ArrayList<Curso> myListCursos(){
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("JavaScript", 20.0,10.0,24));
		cursos.add(new Curso("Java", 40.0,20.0,24));
		cursos.add(new Curso("PHP", 40.0,12.0,24));
		
		return(cursos);
	}
	
	public ArrayList<Curso> buscarCursos(String name){
		ArrayList<Curso> cursos_aux = new ArrayList<>();
		ArrayList<Curso> cursos_return = new ArrayList<>();
		cursos_aux = this.myListCursos();
		System.out.println("Método "+name);
		for (Curso curso:cursos_aux) {
			if (curso.getName().contains(name)) {
				cursos_return.add(curso);
			}
		}
		return cursos_return;
	}
	
	public ArrayList<Curso> postCurso(Curso curso){
		ArrayList<Curso> cursos = new ArrayList<>();
		cursos = this.myListCursos();
		cursos.add(curso);
		this.cursos = cursos;
		return this.cursos;
	}
	
	public ArrayList<Curso> deleteCurso(String name){
		ArrayList<Curso> cursos = new ArrayList<>();
		cursos = this.myListCursos();
		cursos.removeIf(c->c.getName().equals(name));
		this.cursos = cursos;
		return this.cursos;
	}
	
}
