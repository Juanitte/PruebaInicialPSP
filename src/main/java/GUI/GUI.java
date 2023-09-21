package GUI;

import java.util.Scanner;

public class GUI {

    public static void printLogo() {
        String logo = "\u001B[32m ####                         ##\n" + // Código ANSI para color verde
                "\u001B[0m  ##\n" +  // Restablecer el color a predeterminado
                "\u001B[32m  ##       ####     ### ##   ###     #####\n" + // Código ANSI para color verde
                "\u001B[0m  ##      ##  ##   ##  ##     ##     ##  ##\n" + // Restablecer el color a predeterminado
                "\u001B[32m  ##   #  ##  ##   ##  ##     ##     ##  ##\n" + // Código ANSI para color verde
                "\u001B[0m  ##  ##  ##  ##    #####     ##     ##  ##\n" + // Restablecer el color a predeterminado
                "\u001B[32m #######   ####        ##    ####    ##  ##\n" + // Código ANSI para color verde
                "\u001B[0m                   #####\n"; // Restablecer el color a predeterminado

        printSlowly(logo, 5); // Ajusta la velocidad de impresión aquí (en milisegundos)
    }

    public static void printMenu() {
        String greenColor = "\u001B[32m"; // Código ANSI para color verde
        String resetColor = "\u001B[0m"; // Restablecer el color a predeterminado

        String menuLine1 = greenColor + "+-----------------------------+" + resetColor;
        String menuLine2 = greenColor + "| \uD835\uDD78\uD835\uDD8A\uD835\uDD93\uD835\uDD9A \uD835\uDD7B\uD835\uDD97\uD835\uDD8E\uD835\uDD93\uD835\uDD88\uD835\uDD8E\uD835\uDD95\uD835\uDD86\uD835\uDD91 |" + resetColor;
        String menuLine3 = greenColor + "+-----------------------------+" + resetColor;
        String menuLine4 = greenColor + "| \uD835\uDFCF) \uD835\uDD74\uD835\uDD93\uD835\uDD8E\uD835\uDD88\uD835\uDD8E\uD835\uDD86\uD835\uDD97 \uD835\uDD98\uD835\uDD8A\uD835\uDD98\uD835\uDD8E\uD835\uDD94\uD835\uDD93 |" + resetColor;
        String menuLine5 = greenColor + "| \uD835\uDFD0)\uD835\uDD6E\uD835\uDD97\uD835\uDD8A\uD835\uDD86\uD835\uDD97 \uD835\uDD88\uD835\uDD9A\uD835\uDD8A\uD835\uDD93\uD835\uDD99\uD835\uDD86 |" + resetColor;
        String menuLine6 = greenColor + "| \uD835\uDFD1) \uD835\uDD7E\uD835\uDD86\uD835\uDD91\uD835\uDD8E\uD835\uDD97 |" + resetColor;
        String menuLine7 = greenColor + "+-----------------------------+" + resetColor;

        System.out.println(menuLine1);
        System.out.println(menuLine2);
        System.out.println(menuLine3);
        System.out.println(menuLine4);
        System.out.println(menuLine5);
        System.out.println(menuLine6);
        System.out.println(menuLine7);
    }



    public static void printLoginMenu() {
        String greenColor = "\u001B[32m"; // Código ANSI para color verde
        String resetColor = "\u001B[0m"; // Restablecer el color a predeterminado
        Scanner scanner = new Scanner(System.in);

        System.out.println(greenColor + "\uD835\uDD7B\uD835\uDD94\uD835\uDD97 \uD835\uDD8B\uD835\uDD86\uD835\uDD9B\uD835\uDD94\uD835\uDD97, \uD835\uDD8E\uD835\uDD93\uD835\uDD8E\uD835\uDD88\uD835\uDD8E\uD835\uDD8A \uD835\uDD98\uD835\uDD8A\uD835\uDD98\uD835\uDD8E\uD835\uDD94\uD835\uDD93:" + resetColor);
        System.out.print(greenColor + "\uD835\uDD79\uD835\uDD94\uD835\uDD92\uD835\uDD87\uD835\uDD97\uD835\uDD8A \uD835\uDD9A\uD835\uDD98\uD835\uDD9A\uD835\uDD86\uD835\uDD97\uD835\uDD8E\uD835\uDD94: " + resetColor);
        String usuario = scanner.nextLine();
        System.out.print(greenColor + "\uD835\uDD6E\uD835\uDD94\uD835\uDD93\uD835\uDD99\uD835\uDD97\uD835\uDD86\uD835\uDD98\uD835\uDD8A\uD835\uDD93\uD835\uDD86: " + resetColor);
        String password = scanner.nextLine();
    }


    public static void printSlowly(String text, long delay) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
