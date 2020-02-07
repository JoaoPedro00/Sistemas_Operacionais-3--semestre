package controller;

public class ThreadMostra extends Thread {
	private int valor;

	public ThreadMostra(int valor) {
		this.valor = valor; 
	}
	public void run() {
		calc();
	}
	// Decimal format
	private void calc() {
			
		System.out.println(valor);
		}

}
