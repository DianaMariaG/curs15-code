package ro.fasttrackit.curs15.homework.ex2;

public class StringUtils {
    public static String ensureNotEmpty (String word) throws IllegalArgumentException {
        if(word == null || "".equals(word.trim())) {
            throw new IllegalArgumentException("Name is not valid!");
        } else {
            return word;
        }
    }
    public static int validAge (int age) throws IllegalArgumentException {
        if (age > 0 && age <= 120) {
            return age;
        } else {
            throw new IllegalArgumentException("Age is not valid!");
        }
    }
}
