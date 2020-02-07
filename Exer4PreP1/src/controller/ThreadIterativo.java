package controller;

public class ThreadIterativo extends Thread{
	private long Numero;

	public ThreadIterativo(long numero) {
		this.Numero = numero;
	}
	
	public void run() {
		long t = System.nanoTime();
		System.out.println("Fatorial de "+Numero+ " é " +fatorial(Numero));
		tempo(t);
	}

	
	private long fatorial(long Numero) {
		long i,fat;
		fat = 1;
		for(i =1;i<=Numero;i++) {
			fat = fat * i;
		}
		return fat;
	}

	private void tempo(long t) {
		t = System.nanoTime() - t;	
		System.out.println(" a operação Iterativa demorou "+t+" nano segundos");
	}
	
	
}


