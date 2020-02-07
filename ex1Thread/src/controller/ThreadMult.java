package controller;

public class ThreadMult extends Thread {
	private int valor;

	public ThreadMult(int valor) {
		this.valor = valor; 
	}
	public void run() {
		calc();
	}
	// Decimal format
	private void calc() {
		int par = 0;
		int imp = 0;
		double operacao = 0;
		if (valor % 2 ==0) {
			par = valor;
			operacao= valor * valor;
			System.out.println("o quadrado do numero " +par+ " é " +operacao);
		}
		else {
			imp = valor;
			operacao = Math.sqrt(valor);
			System.out.println("a raiz do numero é " +imp + " é  " +operacao);
		}
		
	}

}
