package com.treinopoo.executavel;

import com.treinopoo.aluno.Aluno;
import com.treinopoo.aluno.Disciplina;

public class TesteArray {

	public static void main(String[] args) {

		double[] notas = { 7.7, 7.8, 6.7, 8.9 };
		double[] notas2 = { 8.7, 3.8, 9.7, 3.9 };

		// criação de aluno
		Aluno aluno = new Aluno();
		aluno.setNome("frederico");
		aluno.setIdade(44);
		aluno.setMatricula("786");
		aluno.setCpf("55456654655533");

		// criação de disciplina
		Disciplina disciplina = new Disciplina();
		disciplina.setDisciplina(22);
		disciplina.setNota(notas);

		// adicionando disciplina ao aluno
		aluno.getDisciplinas().add(disciplina);

		// criação de disciplina
		Disciplina disciplina2 = new Disciplina();
		disciplina2.setDisciplina(23);
		disciplina2.setNota(notas2);

		// adicionando disciplina ao aluno
		aluno.getDisciplinas().add(disciplina2);

		double maiorNota = 0;
		System.out.println("as disciplinas do aluno " + aluno.getNome() + " são: ");
		for (Disciplina disc : aluno.getDisciplinas()) {
			System.out.println(disc.getDisciplina());
			System.out.println("e suas notas são: ");
			for (int i = 0; i < disc.getNota().length; i++) {
				System.out.println(disc.getNota()[i]);

				if (i == 0) {
					maiorNota = disc.getNota()[i];
				} else {
					if (maiorNota < disc.getNota()[i]) {
						maiorNota = disc.getNota()[i];
					}
				}

			}
			System.out.println("a maior nota é: " + maiorNota);
		}

		Aluno[] alunos = new Aluno[1];
		alunos[0] = aluno;
		for (int i = 0; i < alunos.length; i++) {
			System.out.println(alunos[i].getNome());
			for (Disciplina disc : alunos[i].getDisciplinas()) {
				System.out.println(disc.getDisciplina());
				for (int t = 0; t < disc.getNota().length; t++) {
					System.out.println(disc.getNota()[t]);
				}
			}
		}
	}

}
