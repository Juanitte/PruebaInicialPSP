package model.domain;

import DAO.UserDAO;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private String username;
    private String password;

    public User() {
        this.username = "";
        this.password = "";
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return username;
    }

    /**
     * Method that stores a new User at the database.
     * @return the stored User.
     */
    public User create() throws Exception {
        try (UserDAO udao = new UserDAO()) {
            udao.save(this);
        }
        return this;
    }


    /**
     * Method that updates a User stored at the database.
     * @param user , the new User.
     * @return the updated User.
     */
    public User update(User user) throws Exception {
        try (UserDAO udao = new UserDAO()) {
            if(udao.findByName(user.getUsername()) != null){
                udao.save(user);
            }else{
                udao.save(user);
            }
        }
        return user;
    }

    /**
     * Method that removes a User from the database.
     */
    public void remove() throws Exception {
        try (UserDAO udao = new UserDAO()) {
            udao.delete(this);
        }
    }
}
