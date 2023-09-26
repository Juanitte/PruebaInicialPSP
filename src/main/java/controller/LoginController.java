package controller;
import DAO.UserDAO;
import GUI.GUI;
import model.domain.User;
import utils.AppData;
import utils.Util;

import java.util.Objects;
import java.util.Scanner;


public class LoginController {

    public void ejecutarMenuPrincipal() throws Exception {
        int option;
        do {
            GUI.printLogo();
            GUI.printMenu();
            option = Util.intInput("Elige una opción: ");
            controlarMenuPrincipal(option);
        }while(option!=3);
    }

    public void controlarMenuPrincipal(int option) throws Exception {
        switch (option) {
            case 1 -> printLoginMenu();
            case 2 -> printRegisterMenu();
            case 3 -> salir();
            default -> Util.muestraMensaje("Opción incorrecta");
        }
    }

    public void printLoginMenu() throws Exception {

            System.out.println("=== Iniciar Sesión ===");
            System.out.print("Usuario: ");
            String usuario = Util.stringInput("");
            System.out.print("Contraseña: ");
            String contrasena = Util.stringInput("");

            try (UserDAO udao = new UserDAO()) {

                User userTemp = udao.findByName(usuario);
                if(userTemp.getUsername() != "") {
                    if(AppData.getPa().authenticate(contrasena, userTemp.getPassword())) {
                        AppData.setActiveUser(userTemp);
                    }else{
                        System.out.println("Contraseña incorrecta");
                        ejecutarMenuPrincipal();
                    }
                }else{
                    System.out.println("Usuario no encontrado.");
                    ejecutarMenuPrincipal();
                }
            }

            System.out.println("Autenticación completada.");
            printUserMenu();

    }

    public void printRegisterMenu() throws Exception {
            System.out.println("=== Registro ===");
            System.out.print("Usuario: ");
            String usuario = Util.stringInput("");
            System.out.print("Contraseña: ");
            String contrasena = Util.stringInput("");

            try(UserDAO udao = new UserDAO()) {
                User userTemp = udao.findByName(usuario);
                if(userTemp.getUsername() == "") {
                    User user = new User(usuario,contrasena);
                    user.create();
                    AppData.setActiveUser(user);

                }else{
                    System.out.println("El usuario ya existe.");
                    ejecutarMenuPrincipal();
                }
            }

            System.out.println("Usuario registrado.");
            printUserMenu();
    }

    public void printUserMenu() throws Exception {
        int opt = -1;
        do {
            System.out.println("=== "+AppData.getActiveUser().getUsername()+" ===");
            System.out.println("1. Cambiar Contraseña");
            System.out.println("2. Cerrar Sesión");
            opt = Util.intInput("Elige una opción: ");
        }while (opt != 1 && opt != 2);
        controlUserMenu(opt);

    }

    public void controlUserMenu(int opt) throws Exception {
        switch (opt) {
            case 1 -> printChPassMenu();
            case 2 -> cerrarSesion();
            case 3 -> salir();
            default -> Util.muestraMensaje("Opción incorrecta");
        }
    }

    public void printChPassMenu() throws Exception {
        System.out.println("=== Cambiar Contraseña ===");
        String newPass = Util.stringInput("Introduce la nueva contraseña: ");
        if(!Objects.equals(newPass, "")){
            AppData.getActiveUser().update(new User(AppData.getActiveUser().getUsername(), newPass));
            System.out.println("Contraseña cambiada");
            printUserMenu();
        }else{
            System.out.println("Contraseña no cambiada");
            printUserMenu();
        }
    }

    public void cerrarSesion() throws Exception {
        AppData.setActiveUser(new User());
        ejecutarMenuPrincipal();
    }

    public void salir() {
        System.exit(0);
    }

}




