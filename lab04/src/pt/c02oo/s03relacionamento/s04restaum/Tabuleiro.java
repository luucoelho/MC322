package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	char board[][];
	// cria um segundo tabuleiro de pecas, que vai guardar seus estados e posições
	Peca segundoTabuleiro[][];
	
	// construtor do tabuleiro
	public Tabuleiro (char board[][]) {
		this.board = board;
		this.segundoTabuleiro = new Peca[7][7];
		for (int i  = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (i < 2 && j < 2) {
					segundoTabuleiro[i][j] = new Peca(i, j, "vazia", "fora");
				}
				else if (i < 2 && j > 4) {
					segundoTabuleiro[i][j] = new Peca(i, j, "vazia", "fora");
				}
				else if (i > 4 && j < 2) {
					segundoTabuleiro[i][j] = new Peca(i, j, "vazia", "fora");
				}
				else if (i > 4 && j > 4) {
					segundoTabuleiro[i][j] = new Peca(i, j, "vazia", "fora");
				}
				else if (i == 3 && j == 3) {
					segundoTabuleiro[i][j] = new Peca(i, j, "vazia", "dentro");
				}
				else {
					segundoTabuleiro[i][j] = new Peca(i, j, "preenchida", "dentro");
				}
			}
		}
	}
	
	// metodo para as tentativas, verificando as condiçoes necessarias para o movimento
	public char[][] tentativa(int origemI, int origemJ, int destinoI, int destinoJ) {
		if (segundoTabuleiro[origemI][origemJ].posValida == "preenchida") {
			if (segundoTabuleiro[destinoI][destinoJ].posValida == "vazia" && segundoTabuleiro[destinoI][destinoJ].posTabuleiro == "dentro") {
				
				board[destinoI][destinoJ] = 'P';
				board[origemI][origemJ] = '-';
				board[(origemI + destinoI)/2][(origemJ + destinoJ)/2] = '-';
				
				segundoTabuleiro[destinoI][destinoJ].posValida = "preenchida";
				segundoTabuleiro[origemI][origemJ].posValida = "vazia";
				segundoTabuleiro[(origemI + destinoI)/2][(origemJ + destinoJ)/2].posValida = "vazia";
				
			}
		}
	return board;
	}
}
