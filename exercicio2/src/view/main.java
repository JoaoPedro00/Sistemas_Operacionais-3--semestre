package view;

import javax.swing.JOptionPane;

import controller.Processos;

public class main {
	public static void main(String [] args) {
		Processos proc = new Processos();
		String os = proc.os();
		System.out.println(os);
		int opc=10;
		while(opc !=9){
	            opc = Integer.parseInt(JOptionPane.showInputDialog("Digite uma opção: \n 1- ver os processos ativos \n 2- Matar um processo \n 9- Fim"));
	            switch(opc){
	                case 1: proc.leProcesso(os); 
	                    break;
	                case 2:  
	            		String info = JOptionPane.showInputDialog("digite o nome ou PID do processo");
	                	proc.mataProcesso(os,info);;
	                    break;
	                case 9: JOptionPane.showMessageDialog(null, "Acabou!!!");
	            }
			}
		}
	
	}
	
