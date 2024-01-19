package com.treinamentothread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaThread extends JDialog {

	private JPanel jpanel = new JPanel(new GridBagLayout()); // painel de componentes

	private JLabel descricaoHora = new JLabel("Nome");
	private JTextField mostraTempo = new JTextField();

	private JLabel descricaoHora2 = new JLabel("Email");
	private JTextField mostraTempo2 = new JTextField();

	private JButton jbuttonAddLista = new JButton("Add lista");
	private JButton jbuttonStop = new JButton("stop");
	
	//depois de ter criado a a classe thread vamos instancia-la na classe de tela
	ImplementacaoFilaThread fila = new ImplementacaoFilaThread();	

	// executa o que estiver dentro no momento da execução
	public TelaThread() {

		setTitle("===Tela Teste Thread===");
		setSize(240, 240);
		setLocationRelativeTo(null);
		setResizable(false);

		GridBagConstraints gridBagConstraints = new GridBagConstraints(); // controladorde posicionamneto de
																			// componentess
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.insets = new Insets(5, 10, 5, 10);
		gridBagConstraints.anchor = gridBagConstraints.WEST;

		descricaoHora.setPreferredSize(new Dimension(200, 25));
		jpanel.add(descricaoHora, gridBagConstraints);

		mostraTempo.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jpanel.add(mostraTempo, gridBagConstraints);

		descricaoHora2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jpanel.add(descricaoHora2, gridBagConstraints);

		mostraTempo2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jpanel.add(mostraTempo2, gridBagConstraints);

		gridBagConstraints.gridwidth = 1;

		jbuttonAddLista.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy++;
		jpanel.add(jbuttonAddLista, gridBagConstraints);

		jbuttonStop.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx++;
		jpanel.add(jbuttonStop, gridBagConstraints);

		jbuttonAddLista.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // executa o click do botão
				
				ObjetoFilaThread objetoFilaThread = new ObjetoFilaThread();
				objetoFilaThread.setNome(mostraTempo.getText());
				objetoFilaThread.setEmail(mostraTempo2.getText());
				
				fila.add(objetoFilaThread);

			}
		});

		jbuttonStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // executa o click do botão
				
				fila.stop();
			}
		});
		
		fila.start();//toda thread precisa ser iniciada
		
		add(jpanel, BorderLayout.WEST);
		// sempre sera o ultimo campo e torna visivel ao usuário
		setVisible(true);

	}

}
