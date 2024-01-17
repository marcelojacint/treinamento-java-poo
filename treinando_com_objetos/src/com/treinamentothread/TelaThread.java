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
	
	private JPanel jpanel = new JPanel(new GridBagLayout()); //painel de componentes
	
	private JLabel descricaoHora = new JLabel("Hora thread1");
	private JTextField mostraTempo = new JTextField();
	
	private JLabel descricaoHora2 = new JLabel("Hora thread2");
	private JTextField mostraTempo2 = new JTextField();
	
	private JButton jbuttonStart = new JButton("start");
	private JButton jbuttonStop = new JButton("stop");
	
	private Runnable threadRun = new Runnable() {
		
		@Override
		public void run() {
			while(true) {
				mostraTempo.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm.ss").
						format(Calendar.getInstance().getTime()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			
		}
	};
	
	private Thread threadTime1;
	
private Runnable threadRun2 = new Runnable() {
		
		@Override
		public void run() {
			while(true) {
				mostraTempo2.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm.ss").
						format(Calendar.getInstance().getTime()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			
		}
	};
	
	private Thread threadTime2;
	
	//executa o que estiver dentro no momento da execução
	public TelaThread() {
		
		setTitle("===Tela Teste Thread===");
		setSize(240, 240);
		setLocationRelativeTo(null);
		setResizable(false);
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints(); // controladorde posicionamneto de componentess
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.insets = new Insets(5, 10, 5, 10);
		gridBagConstraints.anchor = gridBagConstraints.WEST;
		
		descricaoHora.setPreferredSize(new Dimension(200, 25));
		jpanel.add(descricaoHora, gridBagConstraints);
		
		mostraTempo.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		mostraTempo.setEditable(false);
		jpanel.add(mostraTempo, gridBagConstraints);
		
		descricaoHora2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jpanel.add(descricaoHora2, gridBagConstraints);
		
		mostraTempo2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		mostraTempo2.setEditable(false);
		jpanel.add(mostraTempo2, gridBagConstraints);
		
		gridBagConstraints.gridwidth = 1;
		
		jbuttonStart.setPreferredSize(new Dimension(92,25));
		gridBagConstraints.gridy++;
		jpanel.add(jbuttonStart, gridBagConstraints);
		
		jbuttonStop.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx++;
		jpanel.add(jbuttonStop, gridBagConstraints);
		
		jbuttonStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { //executa o click do botão
				
				threadTime1 = new Thread(threadRun);
				threadTime1.start();
				}
		});
		
jbuttonStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { //executa o click do botão
				threadTime1.stop();
				}
		});

jbuttonStart.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) { //executa o click do botão
		
		threadTime2 = new Thread(threadRun2);
		threadTime2.start();
		}
});

jbuttonStop.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) { //executa o click do botão
		threadTime2.stop();
		}
});
		
		
		
		add(jpanel, BorderLayout.WEST);
		//sempre sera o ultimo campo e torna visivel ao usuário
		setVisible(true);
		
	}
}
