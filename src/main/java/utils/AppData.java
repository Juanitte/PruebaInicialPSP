package utils;

public class AppData {
    private static PasswordAuthentication pa = new PasswordAuthentication();

    public static PasswordAuthentication getPa() {
        return pa;
    }

    public static void setPa(PasswordAuthentication pa) {
        AppData.pa = pa;
    }
}
