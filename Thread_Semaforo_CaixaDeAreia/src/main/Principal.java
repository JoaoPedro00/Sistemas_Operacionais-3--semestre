package main;

import java.util.concurrent.Semaphore;

import controller.ThreadCaixa;

public class Principal {

	public static void main(String[] args) {

		int permissoes = 1;
		Semaphore semaforo1 = new Semaphore(permissoes);
		Semaphore semaforo2 = new Semaphore(permissoes);
		Semaphore semaforo3 = new Semaphore(permissoes);
		for(int idCompetidor=0;idCompetidor<21;idCompetidor++) {
			Thread tCaixa = new ThreadCaixa(idCompetidor,semaforo1,semaforo2,semaforo3);
			tCaixa.start();
	}
	}
}
