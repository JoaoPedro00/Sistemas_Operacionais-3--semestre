 package view;

import controller.ThreadMult;

public class Principal {

	public static void main(String[] args) {
		for (int op = 0; op<5 ; op++) {
		int valor = (int)(Math.random() * 41);
		Thread thread = new ThreadMult(valor);
		thread.start();
	}

}
}
