package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class OpProcessos {
	public OpProcessos() {
		super();
	}

	public String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void chamaProcesso(String processo) {
		try {
			Runtime.getRuntime().exec(processo);
		} catch (IOException e) {
			if(e.getMessage().contains("740")) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c ");
				buffer.append(processo);
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, e.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);

			}
	
		}
	}
	
	public void leProcesso(String processo) {
		try {
			Process proc = Runtime.getRuntime().exec(processo);
			InputStream Fluxo = proc.getInputStream(); 
			InputStreamReader leitor = new InputStreamReader(Fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void mataProcesso(String info) {
		StringBuffer buffer = new StringBuffer();
		String cmdNome = "TASKKILL /IM ";
		String cmdPID = "TASKKILL /PID ";
		int pid = 0;
		try {
			pid = Integer.parseInt(info);
			buffer.append(cmdPID);
			buffer.append(pid);
		} catch (NumberFormatException e) {
			buffer.append(cmdNome);
			buffer.append(info);
		}
		finally {
			chamaProcesso(buffer.toString());
			
		}
	}
}
