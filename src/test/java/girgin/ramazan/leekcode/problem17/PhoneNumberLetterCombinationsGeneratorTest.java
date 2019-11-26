package girgin.ramazan.leekcode.problem17;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneNumberLetterCombinationsGeneratorTest {

    private final PhoneNumberLetterCombinationsGenerator phoneNumberLetterCombinationsGenerator = new PhoneNumberLetterCombinationsGenerator();

    @Test
    public void shouldGenerateForTwoLetters() {
        //given
        String digits = "23";

        //when
        List<String> letterCombinations = phoneNumberLetterCombinationsGenerator.generate(digits);

        //then
        assertThat(letterCombinations).containsExactlyInAnyOrder("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
    }

    @Test
    public void shouldGenerateWhenStringIsEmpty() {
        //given
        String digits = "";

        //when
        List<String> letterCombinations = phoneNumberLetterCombinationsGenerator.generate(digits);

        //then
        assertThat(letterCombinations).isEmpty();
    }

    @Test
    public void shouldGenerateWhenSingleLetter() {
        //given
        String digits = "2";

        //when
        List<String> letterCombinations = phoneNumberLetterCombinationsGenerator.generate(digits);

        //then
        assertThat(letterCombinations).containsExactlyInAnyOrder("a", "b", "c");
    }
}
