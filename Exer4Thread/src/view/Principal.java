package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import controller.CarroController;

public class Principal extends JFrame {
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Principal frame = new Principal();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}


		
public Principal() {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 450, 300);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JLabel lblcarro1 = new JLabel("carro1");
				lblcarro1.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblcarro1.setBounds(0, 25, 68, 74);
				contentPane.add(lblcarro1);
				
				JLabel lblcarro2 = new JLabel("carro2");
				lblcarro2.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblcarro2.setBounds(0, 64, 68, 74);
				contentPane.add(lblcarro2);
				
				JButton btnIniciar = new JButton("Iniciar");
				btnIniciar.setBounds(0, 0, 89, 23);
				contentPane.add(btnIniciar);
				
				 JLabel lperdedor = new JLabel("perdedor:");
				 lperdedor.setBounds(120,200,60,30);
				 add(lperdedor);
				 
				 JLabel lvencedor = new JLabel("vencedor:");
				 lvencedor.setBounds(120,180,60,30);
				 add(lvencedor);
				  
				 JTextField TNome1 = new JTextField();
				 TNome1.setBounds(180,180,200,25);
				 add( TNome1);
				  
				 JTextField TNome = new JTextField();
				 TNome.setBounds(180,203,200,25);
				 add( TNome);
				
				CarroController CarroController =
						new CarroController(lblcarro1, lblcarro2, btnIniciar);
		btnIniciar.addActionListener(CarroController);
	}
}