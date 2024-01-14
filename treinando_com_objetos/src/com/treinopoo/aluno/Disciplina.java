package com.treinopoo.aluno;

import java.util.Arrays;
import java.util.Objects;

public class Disciplina {

	private double disciplina;
	private double[] notas = new double[4];
	
	public double calcularMediaDisciplinas() {
		double calcular = 0;
		for(int cont = 0; cont < notas.length; cont++) {
			calcular += notas[cont];
		}
		return calcular / 4;
	}

	public double[] getNota() {
		return notas;
	}

	public void setNota(double[] nota) {
		this.notas = nota;
	}

	public double getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(double disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(notas);
		result = prime * result + Objects.hash(disciplina);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return Double.doubleToLongBits(disciplina) == Double.doubleToLongBits(other.disciplina)
				&& Arrays.equals(notas, other.notas);
	}

	@Override
	public String toString() {
		return "Disciplina [disciplina=" + disciplina + ", notas=" + Arrays.toString(notas) + "]";
	}

	

}
