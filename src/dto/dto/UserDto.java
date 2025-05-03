package dto.dto;

public class UserDto {
    private int id;
    private String name;
    private String email;

    @Override public String toString(){
        return "UserDto [id=" + id + ", name=" + name + ", email=" + email + "]";
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
