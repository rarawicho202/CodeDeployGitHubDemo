import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class colecction2 {
    public static void main(String[] args) {
        LinkedList<Character> characters = new LinkedList<>();
        Random random = new Random();
        int suma=0;
        for (int i=0;i<10;i++){
            char caracter =(char)(random.nextInt(26)+ 'a');
            characters.add(caracter);
        }
        System.out.println(characters);
        Collections.reverse(characters);
        System.out.println(characters);
    }
}
