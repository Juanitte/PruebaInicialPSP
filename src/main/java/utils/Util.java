package utils;

import java.util.Scanner;

public class Util {

    /**
     * Método que valida que un número introducido sea entero.
     * @param msg , el mensaje a mostrar para pedir el número.
     * @return , el número entero validado.
     */

    public static int intInput(String msg) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        boolean isCorrect = false;
        int number = 0;

        do {
            System.out.print(msg);
            try {
                number = sc.nextInt();
                isCorrect = true;
            }catch(Exception InputMismatchException){
                System.out.println("");
                System.out.println("Numero incorrecto");
                System.out.println("");
                sc.nextLine();
            }
        }while(!isCorrect);

        return number;
    }
    /**
     * Método que valida que han introducido una cadena de texto.
     * @param msg , el mensaje a mostrar para pedir el texto.
     * @return , la cadena de texto que el usuario ha introducido.
     */

    public static String stringInput(String msg) {
        System.out.print(msg);
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public static void muestraMensaje(String msg) {
        System.out.println(msg);
    }
}
