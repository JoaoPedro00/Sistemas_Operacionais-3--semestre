package view;

import controller.ThreadMostra;

public class Principal {

	public static void main(String[] args) {
		for (int cont = 0; cont<5 ; cont++) {
			int valor = (int)(Math.random() * 41);
			Thread thread = new ThreadMostra(valor);
			thread.start();
		}

	
	}

}
