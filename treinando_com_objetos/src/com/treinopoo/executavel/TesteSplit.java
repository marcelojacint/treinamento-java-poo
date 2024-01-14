package com.treinopoo.executavel;

import java.util.Arrays;
import java.util.List;

public class TesteSplit {

	public static void main(String[] args) {
		
		// atributo recebendo string com varias informações
		String texto = "lulu, 70, 99, cerveja e bom";
		
		// criando array e colocando a string texto sendo separada por vírgula pelo método split
		String[] textoArrays = texto.split(",");
		
		// varendo o array e capturando os dados quebrados e adicionados no array
		for(int i = 0; i < textoArrays.length; i++) {
			System.out.println(textoArrays[i]);
		}
		// convertendo array para lista
		List<String> listas = Arrays.asList(textoArrays);
		
		for (String list : listas) {
			System.out.println(list);
		}
		
		// convertendo lista em array
		String[] converterArray = listas.toArray(new String[4]);
		for(int i = 0; i < converterArray.length; i++) {
			System.out.println(converterArray[i]);
		}
	
	}

}
