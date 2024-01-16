package com.treinamentothread;

public class TesteThread {

	public static void main(String[] args) throws InterruptedException {
		
		// thread processando em paralelo a simulação emitindo nota fiscal
		new Thread() {
			
			// todo codigo que queremos que funcione em paralelo, fica dentro desse método
			public void run() {
				
				// for para interação
				for (int i = 0; i < 15; i++) {
					
					// simulação de emissão de nota fiscal
					System.out.println("processando e emitindo nota fiscal!!!");
					
					// try/catch obrigatório para o temporizador de execução
					try {
						Thread.sleep(1000);

					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
			}

		}.start(); 

	}

}
