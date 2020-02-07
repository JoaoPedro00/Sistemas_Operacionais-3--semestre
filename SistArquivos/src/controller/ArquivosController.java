package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class ArquivosController implements IArquivosController {

	@Override
	public void leDir(String caminho) throws IOException {
		File dir = new File(caminho);
		if(dir.isDirectory() && dir.exists()) {
			File[] vetArquivos = dir.listFiles(); //abriu o diretorio
			for(File f : vetArquivos) {
				if (f.isDirectory()) {
					System.out.println("[" +f.getName()+ "]");
				}
			}
			for(File f : vetArquivos) {
				if(f.isFile()) {
			//		leArquivo(f.getAbsolutePath(),f.getName());
					System.out.println(f.getName());
				}
			}
		} else {
			throw new IOException ("Dir. inválido");
		}
	}

	@Override
	public void leArquivo(String caminho, String nome) throws IOException {
		File arq = new File(caminho,nome);
		if(arq.isFile() && arq.exists()) {
			FileInputStream fluxo = new FileInputStream(arq);  //inputStream recebe fluxo bits
			InputStreamReader leitor = new InputStreamReader(fluxo); // coverte o fluxo em string
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo inválido");
		}
	}

	@Override
	public void escreveArquivo(String caminho, String nome) throws IOException {
		boolean existe = false;
		File dir = new File(caminho);
		if (dir.isDirectory()) {
			File arq = new File(dir,nome);
			if(arq.exists()) {
				existe = true;
			}
			String linha = JOptionPane.showInputDialog(null,"Digite:");
			StringBuffer buffer = new StringBuffer();
			while (!linha.equals("Fim")) {
				buffer.append(linha);
				buffer.append("\r\n");
				linha = JOptionPane.showInputDialog(null,"Digite:");
			}
			FileWriter abreArq = new FileWriter(arq, existe);
			PrintWriter escreveArq = new PrintWriter(abreArq);
			escreveArq.write(buffer.toString());
			escreveArq.flush();
			escreveArq.close();
			abreArq.close();
		} else {
			throw new IOException("Não é dir.");
		}
	}

	@Override
	public void abreArquivo(String caminho, String nome) throws IOException {
		Desktop desk = Desktop.getDesktop();
		File arq = new File(caminho,nome);
		if(arq.isFile() && arq.exists()) {
			desk.open(arq);
		} else {
			throw new IOException("Arquivo inválido");
		}
	}

}
