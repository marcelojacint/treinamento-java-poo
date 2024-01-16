package com.treinamentothread;

import javax.swing.JDialog;

public class TelaThread extends JDialog {
	
	//executa o que estiver dentro no momento da execução
	public TelaThread() {
		
		setTitle("===Tela Teste Thread===");
		setSize(240, 240);
		setLocationRelativeTo(null);
		setResizable(false);
		
		//sempre sera o ultimo campo e torna visivel ao usuário
		setVisible(true);
		
	}
}
