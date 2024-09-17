import java.util.Scanner;

public class Jogo{
    public static void limparConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        char continua;
        int erros=0;
        do{
            System.out.println("Jogo Da Forca!\n\n");

            Palavras palavras = new Palavras();
            Forca forca = new Forca();
            
            String PalavradoJogo = palavras.SorteiaPalavra().toUpperCase();
            char[] caracteresDaPalavra = PalavradoJogo.toCharArray();
            char[] palavraAtual = new char[caracteresDaPalavra.length];

            boolean jogoGanho = true;
            do {
                erros = forca.GetPartesArrancadas();
                
                // limparConsole();
                System.out.println("Dica - Fruta");
                forca.MostraForca();

                for(int i=0;i<caracteresDaPalavra.length;i++){
                    if (palavraAtual[i] == '\u0000') {
                        System.out.print("_ ");                        
                    }
                    else{
                        System.out.print(palavraAtual[i] + " ");
                    }
                }
                System.out.println();
                
                System.out.println("Faça seu chute: ");
                String input = sc.nextLine().toUpperCase();
                char[] jogada = input.toCharArray();
                boolean JogadaErrada = true;
                
                for(int i=0;i<caracteresDaPalavra.length; i++){
                    for(int j=0;j<jogada.length;j++){
                        if(jogada[j] == caracteresDaPalavra[i]){
                            palavraAtual[i] = jogada[j];
                            JogadaErrada = false;
                        }
                    }
                }
                System.out.println();

                if (JogadaErrada == true) {
                    forca.TiraMembro();
                }

                for (int i = 0; i < palavraAtual.length; i++){
                    if (palavraAtual[i] != '\u0000') {
                        jogoGanho = true;
                    }
                    else{
                        jogoGanho = false;
                    }
                }

            }while(erros < 4 && jogoGanho == false);
            
            if (jogoGanho == true) {
                System.out.println("PARABÉNS, VOCÊ GANHOU");
                forca.MostraForca();
                System.out.println("Palavra do Jogo: " + PalavradoJogo);
                System.out.println("Partes arrancaras: " + erros);
            }
            
            if (jogoGanho == false) {
                System.out.println("Você perdeu! Tente novamente");
                forca.MostraForca();
                System.out.println("A palavra era: "+PalavradoJogo);
            }
            System.out.println("Jogar novamente? [S/N]\n\n");
            String input_ = sc.next();
            continua = input_.charAt(0);

        }while(continua == 's' || continua == 'S');
        sc.close();
    }
}
