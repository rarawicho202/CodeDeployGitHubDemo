import java.util.Scanner;

import static jdk.internal.icu.text.UTF16.charAt;

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String lectTeclado = new String();

        int raiz=0;

        try {
            /* no me queda claro que tengo que hacer*/
            if ( b > 0){
                raiz = b*b;
                if (a.length() > b ){
                    System.out.println(a.charAt(b-1));

                }


                }else{
                if(b<0){
                    System.out.println("NumeroNegativoExcepcion");
                }
            }




    }catch (CaracterEn ex){
        System.out.println((ex.getMessage("Has intentado recuperar una posición de la cadena de caracteres que no existe")));
    }



    /*
     if(CaracterEn.b > 0){
        if (a.length() >b ){
            System.out.println(a.charAt(b-1));

        }else
            System.out.println("el numero es mas grande que la palabra");
    }
*/
}

    }

