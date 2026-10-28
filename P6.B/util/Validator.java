package util;

public class Validator {
    public static boolean isValidAmount(long amount) {
        return amount > 0;
    }

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }
}