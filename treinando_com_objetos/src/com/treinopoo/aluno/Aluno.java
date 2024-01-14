package com.treinopoo.aluno;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import com.treinopoo.constantes.StatusAluno;

public class Aluno extends Pessoa{

	
	private String matricula;
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public Aluno() {
		
	}
	public Aluno(String nomePadrao) {
		nome = nomePadrao;
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
			mediaNotas += disciplina.calcularMediaDisciplinas();

		return mediaNotas / disciplinas.size();
	}

	public String getAvaliarMediaAluno() {
		if (this.getCalcularMedia() >= 5) {
			if (this.getCalcularMedia() >= 7)
				return StatusAluno.APROVADO;
			else
				return StatusAluno.RECUPERACAO;
		} else {
			return StatusAluno.REPROVADO;
		}

	}
	@Override
	public boolean pessoaMaiorIdade() {
		
		return super.pessoaMaiorIdade();
	}
	public String mensagemMaiorIdade() {
		return this.pessoaMaiorIdade() ? "aluno é de maior" : "aluno é de menor";
	}
	@Override
	public double salario() {
		
		return 600;
	}
}
