package controller;

public class ThreadSomaMat extends Thread {
	private int n1;
	private int n2;
	private int n3;
	private int n4;
	private int n5;

	public ThreadSomaMat(int n1, int n2, int n3, int n4, int n5) {
		this.n1 = n1; 
		this.n2 = n2;
		this.n3 = n3;
		this.n4 = n4;
		this.n5 = n5;
	}
	public void run() {
		calc();
	}
	// Decimal format
	private void calc() {
		int soma = n1 + n2 + n3 + n4 + n5;
		System.out.println("a soma da linha é " + soma );
		
	}

}