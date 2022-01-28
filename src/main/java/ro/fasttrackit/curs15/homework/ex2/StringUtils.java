package ro.fasttrackit.curs15.homework.ex2;

public class StringUtils {
    public static String ensureNotEmpty (String word) {
        return word == null || "".equals(word.trim()) ? "n/a" : word;
    }
    public static int validAge (int age) throws IllegalArgumentException {
        if (age > 0 && age <= 120) {
            return age;
        } else {
            throw new IllegalArgumentException("Age is not valid");
        }
    }
    public static int ensureNotNegative (int value) {
        return Math.max(value, 0);
    }
}
