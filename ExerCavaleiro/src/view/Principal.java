package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCavaleiro;

public class Principal {
	public static void main(String []args) {
			int permissoes = 1;
			Semaphore semaforo = new Semaphore(permissoes);
			for(int cavaleiro=0;cavaleiro<4;cavaleiro++) {
				Thread tCavaleiro = new ThreadCavaleiro(cavaleiro,semaforo);
				tCavaleiro.start();
			}
		}
	}


