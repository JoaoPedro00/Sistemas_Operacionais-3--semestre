package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread{

	private int Pessoa;
	private static int posChegada;
	private static int posSaida;
	private Semaphore semaforo;
	
	public ThreadPessoa(int pessoa,Semaphore semaforo) {
		this.Pessoa = pessoa;
		this.semaforo = semaforo;
	}
	
	public void run() {
		pessoaAndando();
		try {
			semaforo.acquire();
			pessoaPorta();
			pessoaPassa();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	private void pessoaAndando() {
		int distFinal = 200;
		int distPercorrida = 0;
		int desloc =(int)((Math.random()*3)+4);
		int tempo = 1000;
		while (distPercorrida < distFinal) {
			distPercorrida += desloc;
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Pessoa #"+Pessoa+" andou "+distPercorrida+" m.");
		}
		posChegada++;
		System.out.println("Pessoa #"+Pessoa+" foi o "+posChegada+" o. a chegar");
	}
	
	
	public void pessoaPorta() {
		System.out.println("Pessoa #"+Pessoa+" chegou na porta");
		int tempo = (int)((Math.random()*1001)+1000);
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void pessoaPassa() {
		posSaida++;
		System.out.println("Pessoa #"+Pessoa+" foi o "+posSaida +" o. a cruzar a porta");
	}
}

