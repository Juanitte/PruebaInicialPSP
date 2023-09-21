package DAO;

import connections.ConnectionMySQL;
import model.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserDAO implements DAO<User> {

    private final static String FINDALL = "SELECT * FROM user";
    private final static String FINDBYNAME = "SELECT * FROM user WHERE username=?";
    private final static String INSERT = "INSERT INTO user (username,password) VALUES (?,?)";
    private final static String UPDATE = "UPDATE user SET password=? WHERE username=?";
    private Connection conn;
    public UserDAO(Connection conn){
        this.conn=conn;
    }
    public UserDAO(){
        this.conn= ConnectionMySQL.getConnect();
    }

    @Override
    public List<User> findAll() throws Exception {

        List<User> result = new ArrayList<User>();
        try(PreparedStatement pst = this.conn.prepareStatement(FINDALL)) {
            try(ResultSet res = pst.executeQuery()) {
                while(res.next()){
                    User u = new User();
                    u.setUsername(res.getString("username"));
                    u.setPassword(res.getString("password"));
                    result.add(u);
                }
            }
        }
        return result;
    }

    @Override
    public User findByName(String username) throws Exception {

        User result = new User();
        try(PreparedStatement pst = this.conn.prepareStatement(FINDBYNAME)) {
            pst.setString(1, username);
            try (ResultSet res = pst.executeQuery()) {
                if(res.next()) {
                    result.setUsername("username");
                    result.setPassword("password");
                }
            }
        }
        return result;
    }

    @Override
    public User save(User entity) throws Exception {
        User result = new User();

        User a = findByName(entity.getUsername());

        if(entity != null){
            if(a.getUsername().equals("")){
                try(PreparedStatement pst = this.conn.prepareStatement(INSERT)){
                    pst.setString(1, entity.getUsername());
                    pst.setString(2, entity.getPassword());
                    pst.executeUpdate();
                }
            }else{
                try(PreparedStatement pst = this.conn.prepareStatement(UPDATE)){
                    pst.setString(1, entity.getPassword());
                    pst.setString(2, entity.getUsername());
                    pst.executeUpdate();
                }
            }
        }

        return result;
    }

    @Override
    public void delete(User entity) throws Exception {

    }

    @Override
    public void close() throws Exception {

    }
}
