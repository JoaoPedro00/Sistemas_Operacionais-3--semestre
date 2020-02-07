package controller;

import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ThreadCarro extends Thread {
	private JLabel lblcarro;
	private JButton btnIniciar;
	
public ThreadCarro(JLabel lblcarro, JButton btnIniciar) {
		this.lblcarro = lblcarro;
		this.btnIniciar = btnIniciar;
}

private void mexeCarro() {
		btnIniciar.setEnabled(false);
		
		Rectangle posicao;
		posicao = lblcarro.getBounds();
		lblcarro.setBounds(posicao);
		int distancia = 400;
		int movimentado = 0;
		int vrum = 0;
		while(movimentado<distancia){
			vrum = (int)(Math.random() * 20);;
			posicao.x = posicao.x + vrum;
		
			lblcarro.setBounds(posicao);
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			movimentado = movimentado + vrum;
		}
		btnIniciar.setEnabled(true);
	}

@Override
public void run() {
	mexeCarro();
	}
}