package com.treinopoo.excecao;

public class ExcecaoProcessarArquivo extends Exception  {
	
	public ExcecaoProcessarArquivo(String erro) {
		super("erro na captura do arquivo " + erro);
	}
}
