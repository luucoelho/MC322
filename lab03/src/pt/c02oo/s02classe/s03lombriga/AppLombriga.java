package pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {

    public static void main(String[] args) {
        Toolkit tk = Toolkit.start();

        String lombrigas[] = tk.recuperaLombrigas();
        Animacao anima = null;
        for (int l = 0; l < lombrigas.length; l++) {
            tk.gravaPasso("=====");
            anima = new Animacao(lombrigas[l]);
        }
        anima.apresenta();
        tk.stop();
    }

}
