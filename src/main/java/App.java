import DAO.UserDAO;
import controller.LoginController;
import model.domain.User;

public class App {
    public static void main(String[] args) throws Exception {
        LoginController obj = new LoginController();
        obj.ejecutarMenuPrincipal();
    }
}
