package lesson10_HWTask2;

import static lesson10_HWTask2.checkCloningType.cloneUser;

public class MyMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        FullName fullName = new FullName("Eva", "N");
        User originalUser = new User("username", "+37512345678", 99, fullName);

        User shallowClone = cloneUser(originalUser, "shallow");
        User deepClone = cloneUser(originalUser, "deep");

        System.out.println("\n\tOriginal user: " + originalUser);
        System.out.println("\n\tShallow clone: " + shallowClone);
        System.out.println("\n\tDeep clone: " + deepClone);
    }
}
