package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPessoa;

public class Porta {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		for(int pessoa=0;pessoa<4;pessoa++) {
			Thread tPessoa = new ThreadPessoa(pessoa,semaforo);
			tPessoa.start();
		}
	}

	}

