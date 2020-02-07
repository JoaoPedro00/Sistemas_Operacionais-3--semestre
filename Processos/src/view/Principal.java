package view;

import controller.OpProcessos;

public class Principal {
	public static void main(String [] args) {
		OpProcessos proc = new OpProcessos();
		String os = proc.os();
		System.out.println(os);
		
    // String processo = "notepade.exe";
    // proc.chamaProcesso(processo);
		
		String processo = "TASKLIST /FO TABLE";
	//	String processo = "ping -t10 www.fateczl.edu.br";
	//	String processo = "TRACERT www.fateczl.edu.br";
		proc.leProcesso(processo);
		
	//	String info = "2332";
		String info = "cmd.exe";
		proc.mataProcesso(info);
		
	}

}
