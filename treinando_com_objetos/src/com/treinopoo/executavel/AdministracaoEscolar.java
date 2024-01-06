package com.treinopoo.executavel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.treinopoo.aluno.Aluno;
import com.treinopoo.aluno.Disciplina;

public class AdministracaoEscolar {

	public static void main(String[] args) {
		
		//lista de alunos
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		//interação para criar objetos alunos
		for (int contador = 0; contador <= 1; contador++) {

			String nome = JOptionPane.showInputDialog("digite seu nome");
			String idade = JOptionPane.showInputDialog("digite seu idade");
			String cpf = JOptionPane.showInputDialog("digite seu cpf");
			String matricula = JOptionPane.showInputDialog("digite seu matricula");
			//criando um novo aluno
			Aluno aluno1 = new Aluno();
			//setando as variaveis no objeto aluno
			aluno1.setNome(nome);
			aluno1.setIdade(Integer.valueOf(idade));
			aluno1.setCpf(cpf);
			aluno1.setMatricula(matricula);
			//deixando a criação de disciplina dinâmica com for
			for (int contador1 = 1; contador1 <= 2; contador1++) {
				//criando um objeto disciplina
				Disciplina disciplina1 = new Disciplina();
				String disciplina = JOptionPane.showInputDialog("escreva a disciplina " + contador1);
				String nota = JOptionPane.showInputDialog("escreva a nota " + contador1);
				//adicionando os dados a disciplina criada
				disciplina1.setDisciplina(Double.valueOf(disciplina));
				disciplina1.setNota(Double.valueOf(nota));
				//settando os dados a lista de disciplinas do objeto aluno
				aluno1.getDisciplinas().add(disciplina1);
			}
			//logica para excluir uma disciplina
			int reposta = JOptionPane.showConfirmDialog(null, "deseja excluir uma disciplina?");

			if (reposta == 0) {

				int continuarOuNao = 0;
				while (continuarOuNao == 0) {
					String escolha = JOptionPane.showInputDialog("escolha disciplina 1 ou 2");
					aluno1.getDisciplinas().remove(Integer.valueOf(escolha).intValue() - 1);
					continuarOuNao = JOptionPane.showConfirmDialog(null, "deseja continuar?");
				}
			}
			alunos.add(aluno1);
		}
		for (Aluno aluno : alunos) {
			if (aluno.getNome().equalsIgnoreCase("leno")) {
				alunos.remove(aluno);
				break;
			}
		}

		for (int cont = 0; cont < alunos.size(); cont++) {
			Aluno aluno = alunos.get(cont);

			if (aluno.getNome().equalsIgnoreCase("lulu")) {
				Aluno novoAluno = new Aluno();
				novoAluno.setNome("novo aluno");
				
				Disciplina disciplina = new Disciplina();
				disciplina.setDisciplina(22);
				disciplina.setNota(9);
				
				novoAluno.getDisciplinas().add(disciplina);
				alunos.set(cont, novoAluno);
				aluno = alunos.get(cont);
			}

			System.out.println("aluno " + aluno.getNome());
			System.out.println("esta com a media " + aluno.getCalcularMedia());
			System.out.println("foi " + aluno.getAvaliarMediaAluno());
			System.out.println(aluno.getDisciplinas());

		}

	}

}
