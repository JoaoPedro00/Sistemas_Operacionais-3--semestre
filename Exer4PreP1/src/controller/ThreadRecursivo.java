package controller;

public class ThreadRecursivo extends Thread {
	private long Numero;

	public ThreadRecursivo(long Numero) {
		this.Numero = Numero;
	}
	
	
	public void run() {
		long t = System.nanoTime();
		System.out.println("Fatorial de "+Numero+ " � " +fatorial(Numero));
		tempo(t);
	}

	
	private long fatorial(long Numero) {
		if(Numero == 0) {
				return 1;
			}
			else {
				return Numero * fatorial(Numero -1 );
			}
	}


	private void tempo(long t) {
		t = System.nanoTime() - t;	
		System.out.println(" a opera��o Recursiva demorou "+t+" nano segundos");
	}
	
	
}
