package pt.c02oo.s02classe.s03lombriga;

public class Animacao {
	Toolkit tk = Toolkit.start();
    public String animacao;
    public AquarioLombriga lomb;
    public Animacao(String animacao) {
        this.animacao = animacao;
        int tamAquario = Integer.parseInt(animacao.substring(0,2));
        int tamLomb = Integer.parseInt(animacao.substring(2,4));
        int posIni = Integer.parseInt(animacao.substring(4,6));
        this.lomb = new AquarioLombriga(tamAquario, tamLomb, posIni);
        tk.gravaPasso(this.lomb.apresenta());
        for (int i = 5; i < this.animacao.length(); i++) {
            if (this.animacao.charAt(i) == 'M') {
                tk.gravaPasso(this.lomb.Mover());
            }
            else if (this.animacao.charAt(i) == 'C') {
                tk.gravaPasso(this.lomb.Crescer());
            }
            else if (this.animacao.charAt(i) == 'V') {
                tk.gravaPasso(this.lomb.Virar());
            }
        }
    }
    String apresenta() {
        return this.lomb.lombriga;
    }
}
