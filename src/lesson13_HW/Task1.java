package lesson13_HW;

public class Task1 {
    public static void userInfo(String login, String password, String confirmPassword) {
        try {
            System.out.println(validate(login, password, confirmPassword));
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    public static class WrongLoginException extends Exception {
        public WrongLoginException(String msg) {
            super(msg);
        }
    }

    public static class WrongPasswordException extends Exception {
        public WrongPasswordException(String msg) {
            super(msg);
        }
    }

    public static String validate(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (password.length() >= 20 || password.contains(" ") || !password.equals(confirmPassword)
                || !password.matches(".*\\d.*")) {
            throw new WrongPasswordException("Password must be less than 20 char, no spaces and at least 1 digit. " +
                    "Two passwords should match!");
        }
        if (login.length() >= 20 || login.contains(" ")) {
            throw new WrongLoginException("Login must be less than 20 char and have no spaces.");
        }
        return "Passed the test";
    }

    public static void main(String[] args) {
        userInfo("validLogin", "ValidPassword99", "ValidPassword99");
        userInfo("notValidLogin", "notValidPassword1", "notValidPassword");
        userInfo("notValidLogin", "ValidPassword99", "ValidPassword99");
    }
}