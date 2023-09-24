import DAO.UserDAO;
import controller.LoginController;
import model.domain.User;

public class App {
    public static void main(String[] args) {
        //LoginController obj = new LoginController();
        //obj.ejecutarMenuPrincipal();

        User user2 = new User();
        try (UserDAO udao = new UserDAO()) {
            user2 = udao.findByName("Juanite");
            if(user2 != null){
                System.out.println("User: "+user2.getUsername());
                System.out.println("Password: "+user2.getPassword());
            }else{
                System.out.println("Error al buscar Usuario");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
