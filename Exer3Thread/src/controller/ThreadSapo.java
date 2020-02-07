package controller;

import java.util.concurrent.Semaphore;

public class ThreadSapo extends Thread {
	private int i;
	private static int lugar=1;
	private Semaphore semaforo;

	public ThreadSapo(int i,Semaphore semaforo) {
		this.i = i;
		this.semaforo = semaforo;
	}
	public void run() {
		calc();
		try {
			semaforo.acquire();
			posicao();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
	
	private void calc() {
		int posicao=0;
		int distancia=20;
		int pulo=0;
		while(posicao<distancia){
			pulo = (int)(Math.random() * 5);
			System.out.println("o sapo "+i+ " saltou "+pulo+" metros");
			posicao = posicao + pulo;
		}
	}
	
	
	private void posicao(){
		System.out.println("o sapo "+i+" chegou em "+lugar+" lugar ");
		lugar++;
	}
}