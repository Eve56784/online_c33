package lesson10_HWTask1;

import java.util.Objects;

public class UserSystemClass {
    private final String username;
    private final String phoneNumber;
    private final int age;

    public UserSystemClass(String username, String phoneNumber, int age){
        this.username=username;
        this.phoneNumber=phoneNumber;
        this.age=age;
    }

    @Override
    public String toString(){
        return "Username:"+username+"\nPhone number:"+phoneNumber+"\nAge:"+age;
    }
    @Override
    public int hashCode(){
        return Objects.hash(username,phoneNumber,age);
    }
    @Override
    public boolean equals(Object object){
        if(this==object)
            return true;
        if(object==null || getClass()!=object.getClass())
            return false;
        UserSystemClass user = (UserSystemClass) object;
        return username.equals(user.username) && phoneNumber.equals(user.phoneNumber) && age==user.age;
    }
}
