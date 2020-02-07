package controller;

import java.util.concurrent.Semaphore;

public class ThreadEstacionamento extends Thread {
	private int IdCarro;
	private Semaphore semaforoCarro;
	private Semaphore semaforoMoto;
	
	
	public ThreadEstacionamento(int IdCarro,Semaphore semaforoCar,Semaphore semaforoMoto) {
		this.IdCarro = IdCarro;
		this.semaforoCarro = semaforoCar;
		this.semaforoMoto = semaforoMoto;
	}
	
	public void run(){
		EscolherAndar();
	}
	
	
	private void EscolherAndar() {
		String vet[]= {"carro","moto"};
		int TipoVei = (int)((Math.random()*2));
		System.out.println("O Veiculo "+IdCarro+" é "+vet[TipoVei] );
		if(TipoVei == 0) {
			try {
				semaforoCarro.acquire();
				AndarCarro();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforoCarro.release();
			}
		}
		else {
			try {
				semaforoMoto.acquire();
				AndarMoto();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforoMoto.release();
			}
		}		
		}
	
	private void AndarCarro() {
		int tempo = (int)((Math.random()*6001)+2000);
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			System.out.println("o carro # "+IdCarro+" Estacionou");
		}
	
	private void AndarMoto() {
		int tempo = (int)((Math.random()*6001)+2000);
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			System.out.println("a moto # "+IdCarro+" Estacionou");
		}

	}

