package controller;

import java.util.concurrent.Semaphore;

//10 carros 1 a 2km de distancia a 50 a 100 m/30 ms
//3 vagas 1 a 3s

public class ThreadCar extends Thread {
	
	private int IdCarro;
	private static int posChegada;
	private static int posSaida;
	private Semaphore semaforo;
	
	public ThreadCar(int idCarro,Semaphore semaforo) {
		this.IdCarro = idCarro;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		carroAndando();
		try {
			semaforo.acquire();
			carroEstac();
			carroSai();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	private void carroAndando() {
		int distFinal = (int)((Math.random()*1001)+1000);
		int distPercorrida = 0;
		int desloc =(int)((Math.random()*51)+50);
		int tempo = 30;
		while (distPercorrida < distFinal) {
			distPercorrida += desloc;
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Carro #"+IdCarro+" andou "+distPercorrida+" m.");
		}
		posChegada++;
		System.out.println("Carro #"+IdCarro+" foi o "+posChegada+" o. a chegar");
	}
	
	
	public void carroEstac() {
		System.out.println("Carro #"+IdCarro+" estacionou");
		int tempo = (int)((Math.random()*2001)+1000);
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void carroSai() {
		posSaida++;
		System.out.println("Carro #"+IdCarro+" foi o "+posSaida +" o. a sair");
	}
}
