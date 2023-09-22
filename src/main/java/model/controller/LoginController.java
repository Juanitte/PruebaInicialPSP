package model.controller;
import GUI.GUI;
import utils.Util;


public class LoginController {

    public void ejecutarMenuPrincipal() {
        int option;
        do {
            GUI.printLogo();
            GUI.printMenu();
            option = Util.intInput("Elige una opción: ");
            controlarMenuPrincipal(option);
        }while(option!=3);
    }

    public void controlarMenuPrincipal(int option) {
        switch (option) {
            case 1 -> GUI.printLoginMenu();
            case 2 -> GUI.printRegisterMenu();
            case 3 -> salir();
            default -> Util.muestraMensaje("Opción incorrecta");
        }
    }

    public void salir() {
        System.exit(0);
    }

}




