package userDB;

import model.User;

import java.sql.*;

public class UserDB {
    private final String url="jdbc:postgresql://localhost:5432/postgres";
    private final String username="postgres";
    private final String password="1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public User getUserById(int id) throws ClassNotFoundException {
        User user = null;
        String sql = "select * from users where id=?";
        Class.forName("org.postgresql.Driver");
        try(Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setLogin(rs.getString("login"));
            }
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public int createUser(User user) {
        String sql = "insert into users(username,login) values(?,?)";
        try(Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getLogin());
            return ps.executeUpdate();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public int changeUserLogin(int id, String newLogin) throws SQLException {
        String sql = "update users set login = ? where id=?";
        try(Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, newLogin);
            ps.setInt(2, id);
            return ps.executeUpdate();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public int deleteUser(int id){
        String sql="delete from users where id =?";
        try(Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
