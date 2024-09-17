import java.util.Random;
import java.text.Normalizer;

public class Palavras {
    private String[] frutas = {
        "Maçã", 
        "Banana", 
        "Laranja", 
        "Uva", 
        "Manga", 
        "Abacaxi", 
        "Melancia", 
        "Morango", 
        "Kiwi", 
        "Pera", 
        "Cereja", 
        "Ameixa", 
        "Pêssego", 
        "Limão", 
        "Coco"
    };

    public String SorteiaPalavra(){
        Random random = new Random();
        int numero = random.nextInt(frutas.length);
        return removerAcentos(frutas[numero]);
    }
    
    public void PalavraSecreta(String palavra){
        System.out.print("Palavra: ");
        for(int i=0;i<palavra.length(); i++){
            System.out.print("_ ");
        }
        System.out.println();
    }

    public String removerAcentos(String palavra) {
        // Normaliza a string para decompor os caracteres acentuados
        String normalizada = Normalizer.normalize(palavra, Normalizer.Form.NFD);

        // Remove os diacríticos (acentos) usando expressão regular
        return normalizada.replaceAll("\\p{M}", "");
    }
}
