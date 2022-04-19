package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
	public int linha;
	public int coluna;
	public String posValida;
	public String posTabuleiro;
	
	// construtor da peça
	public Peca(int linha, int coluna, String posValida, String posTabuleiro) {
		this.linha = linha;
		this.coluna = coluna;
		this.posValida = posValida;
		this.posTabuleiro = posTabuleiro;
	}
	
}
