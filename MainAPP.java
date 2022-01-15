import com.sun.jdi.connect.Connector;

import java.awt.*;
import java.io.*;

public class MainAPP {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("falta el nombre del archivo");
            System.exit(1);

        }

        String fileName =args[0];

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("el nombre del archivo no se encuentra");
            System.exit(2);
        }

        BufferedReader in =new BufferedReader(fileReader);

        String textline =null;
        int contador =0;
        while (true){
            try {
                if (!((textline = in.readLine()) !=null))
                    break;

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("error al leer el archivo de entrada");
                System.exit(3);

            }
            contador++;

        }
        try{
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("el archivo " + fileName + " tiene " + contador + " lineas");
    }


}
