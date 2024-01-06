package com.treinopoo.aluno;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Aluno {

	private String nome;
	private int idade;
	private String cpf;
	private String matricula;

	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, disciplinas, idade, matricula, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(disciplinas, other.disciplinas) && idade == other.idade
				&& Objects.equals(matricula, other.matricula) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", matricula=" + matricula + "]";
	}

	public double getCalcularMedia() {
		double mediaNotas = 0.0;
		for (Disciplina disciplina : disciplinas)
			mediaNotas += disciplina.getNota();

		return mediaNotas / disciplinas.size();
	}

	public String getAvaliarMediaAluno() {
		if (this.getCalcularMedia() >= 5) {
			if (this.getCalcularMedia() >= 7)
				return "aluno aprovado";
			else
				return "aluno em recuperação";
		} else {
			return "aluno reprovado";
		}

	}

}
