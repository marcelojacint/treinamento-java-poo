package com.treinopoo.executavel;

import com.treinopoo.aluno.Aluno;
import com.treinopoo.aluno.Diretor;
import com.treinopoo.aluno.Secretario;

public class ExecutarClassesFilhas {

	public static void main(String[] args) {
		
		
		Aluno aluno = new Aluno();
		aluno.setNome("frederico");
		aluno.setIdade(17);
		
		Diretor diretor = new Diretor();
		diretor.setNome("fred");
		diretor.setIdade(45);
		
		Secretario secretario = new Secretario();
		secretario.setNome("lulu");
		secretario.setIdade(33);
		
		System.out.println(aluno);
		System.out.println(diretor);
		System.out.println(secretario);
		System.out.println(aluno.mensagemMaiorIdade());
		System.out.println("mesada do aluno " + aluno.salario());
		System.out.println("salário diretor " + diretor.salario());
		System.out.println("salário secretário " + secretario.salario());
	}

}
