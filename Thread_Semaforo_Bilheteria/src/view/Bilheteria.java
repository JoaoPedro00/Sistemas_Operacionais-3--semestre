package view;

import java.util.concurrent.Semaphore;

import controller.ThreadBilheteria;

public class Bilheteria {
		public static void main(String []args) {
			int permissoes = 1;
			Semaphore semaforo = new Semaphore(permissoes);
			for(int pessoas=0;pessoas<300;pessoas++) {
				Thread tBilhete = new ThreadBilheteria(pessoas,semaforo);
				tBilhete.start();
			}
		}
	}


