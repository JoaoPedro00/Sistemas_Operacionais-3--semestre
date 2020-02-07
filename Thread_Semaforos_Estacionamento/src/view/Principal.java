package view;

import java.util.concurrent.Semaphore;

import controller.ThreadEstacionamento;


public class Principal {
	public static void main(String []args) {
		int permissoes = 1;
		Semaphore semaforoCar = new Semaphore(permissoes);
		Semaphore semaforoMoto = new Semaphore(permissoes);
		for(int Carro=0;Carro<20;Carro++) {
			Thread tEsta = new ThreadEstacionamento(Carro,semaforoCar,semaforoMoto);
			tEsta.start();
		}
	}
}
