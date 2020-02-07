package controller;

import java.util.concurrent.Semaphore;

public class ThreadCavaleiro extends Thread {

	private int idCavaleiro;
	private int possuiTocha;
	private int possuiPedra;
	private static boolean tochaFoiPega = false;
	private static boolean pedrafoiPega = false;
	private Semaphore semaforoPorta;
	private static int idPortaCerta = (int) (Math.random() * 4);
	private static int escolherPorta=1;

	public ThreadCavaleiro(int idc,Semaphore semaforo) {
		this.idCavaleiro = idc;
		this.possuiTocha = 0;
		this.possuiPedra = 0;
		this.semaforoPorta = semaforo;
	}

	@Override
	public void run() {
		cavaleiroAndando(0, 500);
		System.out.println("Cavaleiro #" + idCavaleiro + " Chegou no Local da Tocha");
		pegarTocha();
		cavaleiroAndando(500, 1500);
		System.out.println("Cavaleiro #" + idCavaleiro + " Chegou no Local da Pedra");
		pegarPedra();
		cavaleiroAndando(1500, 2000);
		System.out.println("Cavaleiro #" + idCavaleiro + " Chegou nas Portas");
		try {
			semaforoPorta.acquire();
			EscolherPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforoPorta.release();
		}
	}

	private void cavaleiroAndando(int distInicial, int distFinal) {
		int distPerocrrida = distInicial;
		int desloc = (((int) ((Math.random() * 3) + 2)) + (2 * this.possuiTocha) + (2 * this.possuiPedra));
		int tempo = 50;
		while (distPerocrrida < distFinal) {
			distPerocrrida += desloc;
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Cavaleiro #" + idCavaleiro + " Andou " + distPerocrrida + " m.");
		}

	}

	private void pegarTocha() {
		if (this.tochaFoiPega == false) {
			this.possuiTocha++;
			this.tochaFoiPega = true;
			System.out.println("O Cavaleiro #" + idCavaleiro + " Pegou a Tocha");
		}
	}

	private void pegarPedra() {
		if (this.pedrafoiPega == false) {
			this.possuiPedra++;
			this.pedrafoiPega = true;
			System.out.println("O Cavaleiro #" + idCavaleiro + " Pegou a Pedra");
		}
	}
	
	private void EscolherPorta() {
		if(escolherPorta==idPortaCerta) {
			escolherPorta++;
			System.out.println("O Cavaleiro #"+ idCavaleiro+" escapou");
		}
		else {
			escolherPorta++;
			System.out.println("O Cavaleiro #"+idCavaleiro+" foi devorado por um monstro");
		}
	}

}