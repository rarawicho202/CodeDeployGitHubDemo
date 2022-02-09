import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class colecction {
    public static void main(String[] args) {
        LinkedList <Integer> integers = new LinkedList<>();

        Random random = new Random();

    int suma = 0;
    for (int i=0;i<25;i++){
        int n = random.nextInt(100)+1;
        suma = suma + n;
        integers.add(n);

    }
    Collections.sort( integers);
    double promedio = (double)suma /integers.size();


    }
}
