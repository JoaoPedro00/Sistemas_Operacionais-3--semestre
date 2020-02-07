package view;

import controller.ThreadIterativo;
import controller.ThreadRecursivo;

public class Principal {
	
	public static void main(String[] args) {
		long numero = (long)((Math.random()*20)+1 );
		Thread tRecursivo = new ThreadRecursivo(numero);
		tRecursivo.start();
		Thread tIterativo = new ThreadIterativo(numero);
		tIterativo.start();
	}

}
