package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
    // atributos e metodos
    // cria construtor com o mesmo nome
    public int tamanhoAquario;
    public int tamanhoLombriga;
    public int posicaoInicial;
    String lombriga = "";
    String virada = "";
    String vir1 = "";
    String vir2 = "";
    String vir3 = "";
    String orient = "esquerda";
    public AquarioLombriga(int tamanhoAquario, int tamanhoLombriga, int posicaoInicial) {
        this.tamanhoAquario = tamanhoAquario;
        this.tamanhoLombriga = tamanhoLombriga;
        this.posicaoInicial = posicaoInicial;

        for (int i = 0; i < posicaoInicial - 1; i++) {
            this.lombriga += '#';
        }
        this.lombriga += '0';

        if (this.lombriga.length() < tamanhoAquario) {
            for (int i = 0; i < tamanhoLombriga - 1; i++) {
                this.lombriga += '@';
            }
        }
        if (this.lombriga.length() < tamanhoAquario) {
            for (int i = posicaoInicial + tamanhoLombriga - 1; i < tamanhoAquario; i++) {
                this.lombriga += '#';
            }
        }
    }
    String Mover() {
        if (this.lombriga.charAt(0) == '0') {
            this.virada = this.lombriga;
            this.lombriga = "";
            for (int i = 0; i < this.virada.length(); i++) {
                this.lombriga = this.virada.charAt(i) + this.lombriga;
            }
            for (int i = 0; i < this.virada.length() + 1; i++) {
                if (this.lombriga.charAt(0) == '#') {
                    this.lombriga = this.lombriga.substring(1);
                    this.lombriga += '#';
                }
            }
            posicaoInicial = tamanhoLombriga;
            this.orient = "direita";
        }
        else if ((this.lombriga.charAt(this.lombriga.length() - 1)) == '0') {
            int i = 0;
            vir1 = "";
            vir2 = "";
            while (i < this.lombriga.length() && this.lombriga.charAt(i) == '#') {
                vir1 += '#';
                i++;
            }
            while (i < this.lombriga.length() && this.lombriga.charAt(i) != '#') {
                vir2 = this.lombriga.charAt(i) + vir2;
                i++;
            }
            this.lombriga = vir1 + vir2;
            this.orient = "esquerda";
            posicaoInicial = tamanhoAquario - tamanhoLombriga + 1;
        }
        else if (this.orient == "esquerda") {
            if (this.lombriga.charAt(0) == '#') {
                this.lombriga = this.lombriga.substring(1);
                posicaoInicial = posicaoInicial - 1;
                    while (this.lombriga.length() < tamanhoAquario)
                        this.lombriga += '#';
            }
        }
        else {
            if (this.lombriga.charAt(this.lombriga.length() - 1) == '#') {
                this.lombriga = this.lombriga.substring(0, this.lombriga.length() - 1);
                this.lombriga = '#' + this.lombriga;
                posicaoInicial += 1;
            }
        }
        return lombriga;
    }

    String Crescer() {
            if (this.orient == "esquerda") {
                if (this.lombriga.charAt(this.lombriga.length() - 1) == '#') {
                    this.lombriga = this.lombriga.substring(0, posicaoInicial + tamanhoLombriga - 1) + '@';
                    tamanhoLombriga += 1;
                    for (int i = this.lombriga.length(); i < tamanhoAquario; i++) {
                        this.lombriga += '#';
                    }
                }
            }
            else {
                if (this.lombriga.charAt(0) == '#') {
                    for (int i = 0; i < this.lombriga.length(); i++) {
                        if (this.lombriga.charAt(i) == '@') {
                            this.lombriga = '@' + this.lombriga.substring(i);
                            tamanhoLombriga += 1;
                        }
                    }
                    while (this.lombriga.length() < tamanhoAquario) {
                        this.lombriga = '#' + this.lombriga;
                    }
                }
            }
        return lombriga;
    }

    String Virar() {
            int i = 0;
            vir1 = "";
            vir2 = "";
            vir3 = "";
            int valorPos = 0;
            while (i < this.lombriga.length() && this.lombriga.charAt(i) == '#') {
                vir1 += '#';
                i++;
            }
            valorPos = i + 1; // caso esteja virada pra direita
            while (i < this.lombriga.length() && this.lombriga.charAt(i) != '#') {
                vir2 = this.lombriga.charAt(i) + vir2;
                i++;
            }
            while(i < this.lombriga.length() && this.lombriga.charAt(i) == '#') {
                vir3 += '#';
                i++;
            }
            this.lombriga = vir1 + vir2 + vir3;
            if (this.orient == "direita") {
                posicaoInicial = valorPos;
                this.orient = "esquerda";
            }
            else if (this.orient == "esquerda") {
                posicaoInicial = valorPos + tamanhoLombriga;
                this.orient = "direita";
            }
            return lombriga;
    }
    String apresenta() {
        return this.lombriga;
    }

}