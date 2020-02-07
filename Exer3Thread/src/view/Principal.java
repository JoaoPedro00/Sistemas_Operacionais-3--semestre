package view;

import java.util.concurrent.Semaphore;

import controller.ThreadSapo;

public class Principal {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		for (int i=1;i<=5;i++){
			Thread thread = new ThreadSapo(i,semaforo);
			thread.start();
		}

	}

}
