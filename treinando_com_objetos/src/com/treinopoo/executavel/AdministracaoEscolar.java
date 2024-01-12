package com.treinopoo.executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
//teste
import com.treinopoo.aluno.Aluno;
import com.treinopoo.aluno.Disciplina;
import com.treinopoo.aluno.Secretario;
import com.treinopoo.classesAuxiliares.AutenticarClasses;
import com.treinopoo.constantes.StatusAluno;
import com.treinopoo.interfaces.PermitirAcesso;

public class AdministracaoEscolar {

	public static void main(String[] args) {

		String login = JOptionPane.showInputDialog("digite a senha: ");
		String senha = JOptionPane.showInputDialog("digite o Usuário: ");

		if (new AutenticarClasses(new Secretario(login, senha)).autenticar()) {

			// lista de alunos
			List<Aluno> alunos = new ArrayList<Aluno>();
			// listas para cada aluno aprovado, reprovado ou em recuperação
			HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

			// interação para criar objetos alunos
			for (int contador = 0; contador <= 2; contador++) {

				String nome = JOptionPane.showInputDialog("digite seu nome");
				String idade = JOptionPane.showInputDialog("digite seu idade");
				String cpf = JOptionPane.showInputDialog("digite seu cpf");
				String matricula = JOptionPane.showInputDialog("digite seu matricula");
				// criando um novo aluno
				Aluno aluno1 = new Aluno();
				// setando as variaveis no objeto aluno
				aluno1.setNome(nome);
				aluno1.setIdade(Integer.valueOf(idade));
				aluno1.setCpf(cpf);
				aluno1.setMatricula(matricula);
				// deixando a criação de disciplina dinâmica com for
				for (int contador1 = 1; contador1 <= 2; contador1++) {
					// criando um objeto disciplina
					Disciplina disciplina1 = new Disciplina();
					String disciplina = JOptionPane.showInputDialog("escreva a disciplina " + contador1);
					String nota = JOptionPane.showInputDialog("escreva a nota " + contador1);
					// adicionando os dados a disciplina criada
					disciplina1.setDisciplina(Double.valueOf(disciplina));
					disciplina1.setNota(Double.valueOf(nota));
					// settando os dados a lista de disciplinas do objeto aluno
					aluno1.getDisciplinas().add(disciplina1);
				}
				// logica para excluir uma disciplina
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
			maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
			maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
			maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
			// interação for para adicionar em cada lista seus respectivos alunos
			for (Aluno aluno : alunos) {
				if (aluno.getAvaliarMediaAluno().equalsIgnoreCase(StatusAluno.APROVADO)) {
					maps.get(StatusAluno.APROVADO).add(aluno);

				} else if (aluno.getAvaliarMediaAluno().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
					maps.get(StatusAluno.RECUPERACAO).add(aluno);

				} else {
					maps.get(StatusAluno.REPROVADO).add(aluno);
				}
			}

			// lendo cada lista é imprimindo na tela os alunos
			System.out.println("----------lista de aprovados!!!");
			for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
				System.out.println(aluno.getNome());
			}
			System.out.println("----------lista dos em recuperação!!!");
			for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
				System.out.println(aluno.getNome());
			}
			System.out.println("----------lista dos reprovados!!!");
			for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
				System.out.println(aluno.getNome());
			}
		} else {
			JOptionPane.showMessageDialog(null, "senha ou ususario inválidos!");
		}

	}

}
