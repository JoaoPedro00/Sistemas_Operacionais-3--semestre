package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

public class CarroController implements ActionListener{
	
	private JLabel lblcarro1;
	private JLabel lblcarro2;
	private JButton btnIniciar;
	
	public CarroController(JLabel lblcarro1,
				JLabel lblcarro2, JButton btnIniciar) {
		this.lblcarro1 = lblcarro1;
		this.lblcarro2 = lblcarro2;
		this.btnIniciar = btnIniciar;
	}
	
	private void botaoCarro(){
		Thread t1 = new ThreadCarro(lblcarro1, btnIniciar);
		Thread t2 = new ThreadCarro(lblcarro2, btnIniciar);
		t1.start();
		t2.start();
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		botaoCarro();
	}
}