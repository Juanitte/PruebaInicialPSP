package GUI;

import model.domain.User;

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Login");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2)); // Ajustado a 4 filas y 2 columnas

        JLabel userLabel = new JLabel("Usuario:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Contraseña:");
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(new JLabel()); // Espacio en blanco
        panel.add(loginButton);

        frame.add(panel);

        // Establecer el tamaño preferido de la ventana
        frame.setPreferredSize(new Dimension(400, 150));

        frame.pack();
        frame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = userField.getText();
                char[] passwordChars = passField.getPassword();
                String password = new String(passwordChars);

                // Lógica de autenticación aquí


                // Mostrar notificación de contraseña guardada
                System.out.println("Contraseña guardada.");

                frame.dispose();
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void printRegisterMenu() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Registro");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2)); // Ajustado a 3 filas y 2 columnas

        JLabel userLabel = new JLabel("Usuario:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Contraseña:");
        JPasswordField passField = new JPasswordField();
        JButton addButton = new JButton("Añadir");

        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(new JLabel()); // Espacio en blanco
        panel.add(addButton);

        frame.add(panel);

        // Establecer el tamaño preferido de la ventana
        frame.setPreferredSize(new Dimension(400, 150));

        frame.pack();
        frame.setVisible(true);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = userField.getText();
                char[] passwordChars = passField.getPassword();
                String password = new String(passwordChars);

                System.out.println("Usuario registrado");
                // Lógica para agregar el usuario y contraseña aquí


                // Cerrar la ventana
                frame.dispose();
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    public static int leeEntero(String msg) {
        System.out.println(msg);
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }
}
