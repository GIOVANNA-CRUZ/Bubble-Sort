import java.util.Random;
import java.util.Scanner;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int listaDesordenada[];
		int listaOrdenada[];
		Sort app = new Sort();

		// Usuario escolher o tamanho da lista
		Scanner lerLista = new Scanner(System.in);
		System.out.println("Insira o tamanho da lista que você deseja:");
		int tamanhoDaLista = lerLista.nextInt();

		// Imprimir a lista ordenada
		listaDesordenada = app.gerarListaAleatoria(tamanhoDaLista);
		listaOrdenada = app.ordenarPorBolha((int[]) listaDesordenada.clone());
		System.out.println("Lista Ordenada:");
		app.imprimirLista(listaOrdenada);

		// Solicita que o usuário escolha um item da lista e o indice é retornado
		// Pula linha
		System.out.println("\n" + "\n" + "Escolha um item da lista ordenada:");
		int itemDaLista = lerLista.nextInt();
		app.buscarPosicaoNaLista(itemDaLista, listaOrdenada);
		app.buscarBinario(itemDaLista, listaOrdenada);

	}

	private int buscarPosicaoNaLista(int valor, int[] lista) {
		// Retorna o indice do valor que o usuário digitar

		int posicao = 0;
		boolean achou = false;

		for (int x = 0; x < lista.length && !achou; x++) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (valor == lista[x]) {
				posicao = x + 1;
				achou = true;
				System.out.println("A posição do elemento escolhido é:" + posicao);
			}
		}

		return posicao;

	}

	private int buscarBinario(int valor, int[] lista) {
		// Busca o valor pedido através de uma busca binária

		int primeiro = 0;
		int posicao = 0;
		int ultimo = lista.length - 1;
		int meio = 0;
		boolean achou = false;

		while (primeiro <= ultimo && !achou) {// percorre a lista e enquanto não achar, continua o programa
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			meio = (primeiro + ultimo) / 2;
			posicao = meio + 1;

			if (valor == lista[meio]) {
				achou = true;
				System.out.println("A posição é " + posicao);

			} else if (valor < lista[meio]) { // Se o valor do meio for maior que o valor escolhido, ele esquece da
												// lista em diante e pega apenas do meio para trás
				ultimo = meio - 1;

			} else { // Se o valor do meio for menor que o valor escolhido, ele esquece do meio para
						// trás e vai para frente
				primeiro = meio + 1;

			}
		}

		return posicao;

	}

	private void imprimirLista(int[] lista) {
		// Imprime a lista separada por vírgula e um elemento ao lado do outro

		String listaImpressa = "";

		for (int y = 0; y < lista.length; y++) {
			listaImpressa = listaImpressa + lista[y] + ",";
		}

		System.out.print(listaImpressa.substring(0, listaImpressa.length() - 1));

	}

	private int[] ordenarPorBolha(int[] lista) {
		// Ordena a lista com o algoritmo bubble sort

		// Roda até que a lista esteja ordenada
		for (int i = 0; i < lista.length; i++) {

			// Percorre todos os elementos do array, um a um
			for (int x = 0; x < lista.length - 1 - i; x++) {

				// Algoritmo de comparação e troca dos vetores

				if (lista[x] > lista[x + 1]) {
					int aux = lista[x];
					lista[x] = lista[x + 1];
					lista[x + 1] = aux;
				}

			}
		}

		return lista;

	}

	private int[] gerarListaAleatoria(int tamanhoLista) {
		// Gera uma lista desordenada
		Random gerador = new Random();

		int valores[] = new int[tamanhoLista];

		for (int x = 0; x < valores.length; x++) {
			valores[x] = gerador.nextInt((10000 - 1000) + 1) + 1000;
		}
		return valores;

	}

}
