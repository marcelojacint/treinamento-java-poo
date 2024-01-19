package com.treinamentothread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

// extendendo da classe Thread tendo assim acesso as seus recursos
public class ImplementacaoFilaThread extends Thread {

	// lista(pilha-fila) static para poder acessar na tela
	private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila = new ConcurrentLinkedQueue<ObjetoFilaThread>();

	// adicionar objeto na lista
	public static void add(ObjetoFilaThread objetoFilaThread) {
		pilha_fila.add(objetoFilaThread);
	}

	@Override
	public void run() {

		System.out.println("fila rodando");

		
		while (true) {
			
			// interface de interação para percorrer a lista
			Iterator iteracao = pilha_fila.iterator();


			synchronized (iteracao) { // bloquear acesso a essa lista por outros processos(apenas essa thread acess
										// essa lista

				while (iteracao.hasNext()) { // enquanto conter dados na lista processar

					// processando os dados
					ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();

					/*
					 * espaço para todo os processos necessários de demanda enviar emails para
					 * vários usuário, notas fiscais, etc
					 */
					System.out.println("=========================================");
					System.out.println(processar.getNome());
					System.out.println(processar.getEmail());

					// depois do processo remove o objeto
					iteracao.remove();

					try {
						Thread.sleep(1000); // dar tempo para descarga de memória
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

			}

			try {
				Thread.sleep(1000); // processou toda lista, tempo para limpeza de memória
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
