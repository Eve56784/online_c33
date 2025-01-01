package lesson10_HWTask1;

public class MyMain {
    public static void main(String[] args) {
        UserSystemClass user1 = new UserSystemClass("Gwen", "+3754567890", 34);
        UserSystemClass user2 = new UserSystemClass("Gwen", "+3754567890", 34);
        UserSystemClass user3 = new UserSystemClass("AJ", "+3754567890", 34);

        System.out.println(user1.equals(user2));
        System.out.println(user1.equals(user3));
    }
}
