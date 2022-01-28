package ro.fasttrackit.curs15.invert;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordInvertorTest {
    WordInvertor wordInvertor;

    @BeforeEach
    public void setup() {
        wordInvertor = new WordInvertor();
    }

    @Test
    @DisplayName("WHEN reversing null THEN throw exception")
    void testReverseNull(){
        //SETUP
        WordInvertor wordInverter = new WordInvertor();
        //RUN + ASSERT
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class,
                () -> wordInverter.reverse(null));
        assertThat(exc.getMessage()).isEqualTo("Cannot revert null");
    }

    @Test
    @DisplayName("WHEN reversing empty string THEN return empty string")
    void testEmptyString() {
        //RUN
        //ASSERT
        assertThat(wordInvertor.reverse("")).isEqualTo("");

    }
    @Test
    @DisplayName("WHEN a single letter THEN retunr letter")
void testSingleLetter(){
        //RUN+ ASSERT
        assertThat(wordInvertor.reverse("a")).isEqualTo("a");
        }
    @Test
    @DisplayName("WHEN reversing word THEN return word")
    void testReverse() {
        //RUN+ASSERT
        assertThat(wordInvertor.reverse("word")).isEqualTo("drow");
    }
}


