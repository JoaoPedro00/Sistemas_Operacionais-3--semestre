package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import org.omg.CORBA.portable.InputStream;

public class RedesController {
   public RedesController(){
	   super();
   }
   public String os() {
	
		String so = System.getProperty("os.name"); 
	
		return so;
	}

	public void chamaProcesso(String caminhos) {

		try {
			Runtime.getRuntime().exec(caminhos); 
		
		} catch (IOException e) {
			if (e.getMessage().contains("sobe")) {
				StringBuffer sb = new StringBuffer();
				sb.append("cmd /c ");
				sb.append(caminhos);
				try {
					Runtime.getRuntime().exec(sb.toString());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				e.printStackTrace();
			}
		}

	}

	public void leProcesso(String caminhos) {
		try {
			Process p = Runtime.getRuntime().exec(caminhos); 
			java.io.InputStream fluxo = p.getInputStream(); 
			InputStreamReader leitor = new InputStreamReader(fluxo);
																	
																	
			BufferedReader buffer = new BufferedReader(leitor); 
																
																
			StringBuffer sb = new StringBuffer();
			String linhas = buffer.readLine(); 

			boolean x = false;

			while (linhas != null) { 



				if (linhas.contains("Adaptador Ethernet")){ 

					sb.append(linhas); 
					sb.append(" \n"); 
					linhas = buffer.readLine();	 

					do{ 

						sb.append(linhas);  

						if (linhas.contains("IPv4")){ 
							x = true; 
						}
						sb.append("\n");
						linhas = buffer.readLine();

					}while (!linhas.contains("Adaptador"));  

					if (x == true){
						System.out.println(sb.toString());
					}else{
						sb.delete (0, sb.length());
					}

				}
				linhas = buffer.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mataProcesso(String processo) {
		String cmdPid = "TASKKILL /PID "; 
											
		String cmdNome = "TASKKILL /IM "; 
											
	
		int pid = 0;
		StringBuffer buffer = new StringBuffer();

		try {
			pid = Integer.parseInt(processo);
			buffer.append(cmdPid);
			buffer.append(pid);
		} catch (NumberFormatException e) {
			buffer.append(cmdNome);
			buffer.append(processo);
		}
		try {
			Runtime.getRuntime().exec(buffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

   }


