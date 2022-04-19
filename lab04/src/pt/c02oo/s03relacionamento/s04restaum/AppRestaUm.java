package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);
   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      
      String commands[] = tk.retrieveCommands();
      
      System.out.println("=== Entrada");
      for (int l = 0; l < commands.length; l++)
         System.out.println(commands[l]);
      
      System.out.println("=== Primeira Saída");
      char board[][] = {
         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
         {'P', 'P', 'P', '-', 'P', 'P', 'P'},
         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
         {' ', ' ', 'P', 'P', 'P', ' ', ' '}
      };
            
      Tabuleiro tabuleiro = new Tabuleiro(board);
      tk.writeBoard("Tabuleiro inicial", board);
      int fixo = 97;
      
      for (int i = 0; i < commands.length; i++) {
    	  int origemJ = commands[i].charAt(0) - fixo;
    	  int origemI = commands[i].charAt(1) - '1';
    	  int destinoJ = commands[i].charAt(3) - fixo;
    	  int destinoI = commands[i].charAt(4) - '1';
    	  
    	  // checa se o movimento que está tentando fazer é na mesma linha ou coluna
    	  if (origemI != destinoI && origemJ != destinoJ) {
    		  System.out.println("Movimento Inválido");
    	  }
    	  // checa se o movimento que esta tentando fazer é pulando apenas uma casa
    	  else if (destinoI - origemI > 2 && destinoJ - origemJ > 2) {
    		  System.out.println("Movimento Inválido");
    	  }
    	  else {
    		  board = tabuleiro.tentativa(origemI, origemJ, destinoI, destinoJ);
    	  }
    	  
    	  String nome = "source: " + commands[i].substring(0, 2) + "; target: " + commands[i].substring(3, 5);
    	  tk.writeBoard(nome, board);
      }
      tk.stop();
   }
   

}
