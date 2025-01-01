package lesson10_HWTask2;

public class checkCloningType {
    public static User cloneUser(User user, String cloningType) throws CloneNotSupportedException {
        if(cloningType.equalsIgnoreCase("shallow"))
            return (User) user.clone();
        else if(cloningType.equalsIgnoreCase("deep"))
            return (User) user.deepClone();
        else
            throw new IllegalArgumentException("Error. Try again.");
    }
}
