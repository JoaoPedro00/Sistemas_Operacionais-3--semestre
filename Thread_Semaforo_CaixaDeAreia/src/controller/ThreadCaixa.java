package controller;

import java.util.concurrent.Semaphore;

public class ThreadCaixa extends Thread {
	private int IdCompetidor;
	private Semaphore semaforo1;
	private Semaphore semaforo2;
	private Semaphore semaforo3;
	
	public ThreadCaixa(int IdCompetidor,Semaphore semaforo1,Semaphore semaforo2,Semaphore semaforo3){
		this.IdCompetidor = IdCompetidor;
		this.semaforo1 = semaforo1;
		this.semaforo2 = semaforo2;
		this.semaforo3 = semaforo3;
	}
	
	public void run(){
		PegarPedra();
		int opc = IdCompetidor%3;
		switch (opc){
		case 0:
			try {
				semaforo1.acquire();
				lancarPedra(opc);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo1.release();
			}
			break;
		case 1:
			try {
				semaforo2.acquire();
				lancarPedra(opc);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo2.release();
			}
			break;
		case 2:
			try {
				semaforo3.acquire();
				lancarPedra(opc);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo3.release();
			}
			break;
		}
	}
	
	private void PegarPedra(){
		int tempo = (int)((Math.random()*3001)+1000);
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			System.out.println("o competidor # "+IdCompetidor+" Pegou a pedra");
		}
	
	
	private void lancarPedra(int opc){
		int dist=0;
		if(opc==0){
			 dist = (int)((Math.random()*4)+5);
		}
		else if(opc==1){
			 dist = (int)((Math.random()*3)+4);
		}
		else{
			 dist = (int)((Math.random()*4)+2);
		}
		int tempo = (int)((Math.random()*201)+100);
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("o competidor # "+IdCompetidor+" jogou a pedra na caixa " +(opc+1)+" a " +dist+" metros");
	}
	}


