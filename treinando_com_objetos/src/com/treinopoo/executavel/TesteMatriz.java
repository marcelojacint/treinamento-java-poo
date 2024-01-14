package com.treinopoo.executavel;

public class TesteMatriz {

	public static void main(String[] args) {
		
		int notas[][] = new int[3][3];
		
		// adicionando dados a matriz
		notas[0][0] = 20;
		notas[0][1] = 40;
		notas[0][2] = 70;
		
		notas[1][0] = 50;
		notas[1][1] = 80;
		notas[1][2] = 60;
		
		notas[2][0] = 45;
		notas[2][1] = 65;
		notas[2][2] = 55;
		
		// for dentro de outro for para varrer a matriz
		for(int i = 0; i < notas.length; i++) {
			System.out.println("linha " + (i + 1) + "º");
			for(int j = 0; j < notas[i].length; j++) {
				System.out.println(notas[i][j]);
			}
			System.out.println("---------------------------------------------");
		}

	}

}
