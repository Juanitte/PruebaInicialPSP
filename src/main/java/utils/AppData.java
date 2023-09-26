package utils;

import model.domain.User;

public class AppData {
    private static PasswordAuthentication pa = new PasswordAuthentication();
    private static User activeUser;

    public static PasswordAuthentication getPa() {
        return pa;
    }

    public static void setPa(PasswordAuthentication pa) {
        AppData.pa = pa;
    }

    public static User getActiveUser() {
        return activeUser;
    }

    public static void setActiveUser(User activeUser) {
        AppData.activeUser = activeUser;
    }
}
