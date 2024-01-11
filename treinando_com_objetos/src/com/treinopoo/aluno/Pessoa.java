package com.treinopoo.aluno;

//super classe
public abstract class Pessoa {

	protected String nome;
	protected int idade;
	protected String cpf;
	
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
	
	// método para saber maior idade
	public boolean pessoaMaiorIdade() {
		return idade >=18;
	}
	
	// método que obriga todas as classes subclasses a implementa-lo
	public abstract double salario();
	
}


