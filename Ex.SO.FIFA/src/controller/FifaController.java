package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class FifaController implements IFifaController {

	@Override
	public Stack<String> empilhaBrasileiros(String caminho, String nome) throws IOException {
		Stack<String> pilha = new Stack<String>();
		File arq = new File(caminho,nome);
		if(arq.isFile() && arq.exists()) {
			FileInputStream fluxo = new FileInputStream(arq);  //inputStream recebe fluxo bits
			InputStreamReader leitor = new InputStreamReader(fluxo); // coverte o fluxo em string
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) {
				String array[] = linha.split(",");
				if(array[5].equals("Brazil")) {
					pilha.push(linha);
				}
				linha = buffer.readLine();
			}
	}
		return pilha;
}

	@Override
	public void desmpilhaBonsBrasileiros(Stack<String> pilha) throws IOException {
		System.out.println("Jogadores brasileiros bons : ");
		int tamanhoPilha = pilha.size();
		for (int i = 0 ; i < tamanhoPilha ; i++){
			String linha = pilha.pop();
			String array[] = linha.split(",");
			if(Integer.parseInt(array[7])>=80) {
				System.out.println(array[2]+" overall "+array[7]	);
			}
			}
		
	}

	@Override
	public List<String> listaRevelacoes(String caminho, String nome) throws IOException {
		List<String> lista = new LinkedList<String>();
		File arq = new File(caminho,nome);
		if(arq.isFile() && arq.exists()) {
			FileInputStream fluxo = new FileInputStream(arq);  //inputStream recebe fluxo bits
			InputStreamReader leitor = new InputStreamReader(fluxo); // coverte o fluxo em string
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
		    linha = buffer.readLine();
			while(linha != null) {
				String array[] = linha.split(",");
				if(Integer.parseInt(array[3])<=20) {
						lista.add(linha);
				}
				linha = buffer.readLine();
			}
	}
		return lista;
}
		

	@Override
	public void buscaListaBonsJovens(List<String> lista) throws IOException {
		int tamanhoLista = lista.size();
		System.out.println("\n Jogadores jovens bons :");
		for (int i = tamanhoLista - 1; i >= 0; i--){
			String linha = lista.get(i);
			String array[] = linha.split(",");
			if(Integer.parseInt(array[7])>=80) {
				System.out.println(array[2]+"| idade :"+array[3] +"| overall "+array[7]);
			}
		} 
	}

}
