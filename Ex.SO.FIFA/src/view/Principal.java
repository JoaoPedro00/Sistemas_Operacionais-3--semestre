package view;

import java.io.IOException;

import controller.FifaController;
import controller.IFifaController;


public class Principal {

	public static void main(String[] args) {

		IFifaController arqCont = new FifaController();
		String caminho = "C:\\TEMP";
		String nome = "data.csv";
		String absolutePath = "C:\\Windows";
		try {
			arqCont.desmpilhaBonsBrasileiros(arqCont.empilhaBrasileiros(caminho, nome));
			arqCont.buscaListaBonsJovens(arqCont.listaRevelacoes(caminho, nome));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}


 