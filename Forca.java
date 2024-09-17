public class Forca{
    private int PartesArrancadas;
    //7X7
    private char Imagem[][] = {
        {' ', ' ', '+', '-', '-', '+', ' '},
        {' ', ' ', '|', ' ', ' ', '|', ' '},
        {' ', ' ', 'O', ' ', ' ', '|', ' '},
        {' ', '/', '|', '\\', ' ', ' ', '|'},
        {' ', '/', ' ', '\\', ' ', ' ', '|'},
        {' ', ' ', ' ', ' ', ' ', '|', ' '},
        {' ', ' ', ' ', ' ', ' ', '|', ' '}
    };

    public Forca(){
        this.PartesArrancadas = 0;
    }
    public int GetPartesArrancadas(){
        return PartesArrancadas;
    }
    public void MostraForca(){

        if(PartesArrancadas == 1){
            Imagem[4][3] = ' ';
        }
        if(PartesArrancadas == 2){
            Imagem[4][1] = ' ';
        }
        if(PartesArrancadas == 3){
            Imagem[3][3] = ' ';
        }
        if(PartesArrancadas == 4){
            Imagem[3][1] = ' ';
        }
        if(PartesArrancadas == 5){
            Imagem[2][2] = ' ';
            Imagem[6][1] = 'O';
        }

        for (int i = 0; i < Imagem.length; i++) {
            for (int j = 0; j < Imagem[i].length; j++) {
                System.out.print(Imagem[i][j]);
            }
            System.out.println();
        }
    } 
    
    public void TiraMembro(){
        PartesArrancadas += 1;
    }

    public void FimDeJogo(String palavraCorreta, int caracteresCorretos){
        System.out.println("FIM DE JOGO!");
        System.out.println("\n A palavra coreta era: " + palavraCorreta);
        System.out.println("\n Letras acertadas: " + caracteresCorretos);
        
    }
}