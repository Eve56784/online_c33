package lesson10_HWTask2;

public class User implements Cloneable{
    private final String username;
    private final String phoneNumber;
    private final int age;
    private FullName fullName;

    public User(String username, String phoneNumber, int age, FullName fullName){
        this.username=username;
        this.phoneNumber=phoneNumber;
        this.age=age;
        this.fullName=fullName;
    }

    @Override
    public String toString(){
        return "\nUsername:"+username+"\nPhone number:"+phoneNumber+"\nAge:"+age+fullName;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Object deepClone() throws CloneNotSupportedException{
        User newUser = (User) super.clone();
        newUser.fullName = (FullName) fullName.clone();
        return newUser;
    }
}
