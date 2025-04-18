package model;

public class User {
    private int id;
    private String username;
    private String login;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUsername() {
        return username;
    }

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }
}
