package controller;

import java.util.concurrent.Semaphore;

public class ThreadBilheteria extends Thread{
	private int idPessoa;
	private Semaphore semaforo;
	private static int Ingressos=100;
	
	
	public ThreadBilheteria(int pessoa,Semaphore semaforo) {
		this.idPessoa = pessoa;
		this.semaforo = semaforo;
	}

	
	public void run() {
		Login();

	}
	
	public void Compra(){
		try {
			semaforo.acquire();
			ValidacaoCompra();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
	
	
	private void ValidacaoCompra() {
		int Compra = (int)((Math.random()*4)+1);
		if(Ingressos < Compra){
			System.out.println("usuario # "+idPessoa+" Indisponibilidade dos ingressos ");
		}
		else{
			Ingressos -= Compra;
			System.out.println("o usuario #"+idPessoa+" comprou "+Compra+" ingressos");
			System.out.println("Restam "+Ingressos+ " ingressos");
		}
	}


	private void ProcessoCompra() {
		int tempo = (int)((Math.random()*3001)+1000);
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(tempo>2500){
			System.out.println("usuario # "+idPessoa+" tempo de sessão estourado");
			//stop();
		}
		else {
			Compra();
		}
	}


	private void Login() {
		int tempo = (int)((Math.random()*2001)+50);
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(tempo>1000) {
			System.out.println("usuario # "+idPessoa+" timeout");
			//stop();
		}
		else{
			ProcessoCompra();
		}
	}
}
