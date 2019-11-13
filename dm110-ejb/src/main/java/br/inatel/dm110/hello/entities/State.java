package br.inatel.dm110.hello.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estado")
public class State implements Serializable {
	
	@Id
	private int ibge;
	
	private String sigla;
	
	private String nome;
	
	private float area;
	
	
	public State() { }

	
	public State(int ibge, String sigla, String nome, float area) {
		this.ibge = ibge;
		this.sigla = sigla;
		this.nome = nome;
	}


	public int getIbge() {
		return ibge;
	}

	public void setIbge(int ibge) {
		this.ibge = ibge;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}
	
	
}
