package ro.fasttrackit.curs15.invert;

public class WordInvertor {
    public String reverse(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Cannot revert null");
        }
        else if (word.length() < 2) {
          return word;
        } else {
            String reverse = "";
            for(int i = word.length()-1; i>=0; i--) {
                reverse = reverse + word.charAt(i); //ia litera de pe pozitia i
            }
            return reverse;
        }
    }
}
