package view;

import java.io.IOException;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {
		IArquivosController arqCont = new ArquivosController();
		String caminho = "C:\\TEMP";
		String nome = "testeSO1.txt";
		String absolutePath = "C:\\Windows";
		try {
		    arqCont.escreveArquivo(caminho, nome);
			arqCont.leArquivo(caminho, nome);
			//arqCont.leDir(absolutePath);
			//arqCont.abreArquivo(caminho, nome);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
