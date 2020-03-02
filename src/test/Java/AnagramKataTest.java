import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileNotFoundException;

public class AnagramKataTest {
    AnagramKata anagramKata;
@Before
public void setUp() throws FileNotFoundException {
 anagramKata = new AnagramKata("wordlist.txt");
}

    @Test
    public void txtFileWordsWithNoDuplicates_AreSplitIntoSets() throws FileNotFoundException {
        Assertions.assertThat(anagramKata.splitIntoSet("jakl")).containsKeys('j', 'k', 'l', 'a');
    }

    @Test
    public void txtFileWordsWithDuplicates_AreSplitIntoSets() throws FileNotFoundException {
        Assertions.assertThat(anagramKata.splitIntoSet("jakkl")).containsKeys('j', 'k', 'l', 'a').containsValue(2);

    }

    @Test
    public void txtFile_checkWordsForAnagram_returns1WhenAnagram() throws FileNotFoundException {
        String word1 = "lolm";
        String word2 = "mlol";
        Assertions.assertThat(anagramKata.checksWordsForAnagram(word1, word2)).isEqualTo(1);
    }

    @Test
    public void txtFile_checkWordsForAnagram_returns0WhenNoAnagram() throws FileNotFoundException
        {
        String word1 = "lollm";
        String word2 = "mlol";
        Assertions.assertThat(anagramKata.checksWordsForAnagram(word1, word2)).isEqualTo(0);
    }

    @Test
    public void returnsNumberOfAnagrams_returnsCorrectNumber_withNoSpecialCharacters() throws FileNotFoundException {
        Assertions.assertThat(anagramKata.returnsNumberOfAnagrams("act")).isEqualTo(2);
    }

    @Test
    public void returnsNumberOfAnagrams_returnsCorrectNumber_withSpecialCharacters() throws FileNotFoundException {
        Assertions.assertThat(anagramKata.returnsNumberOfAnagrams("ac1&t")).isEqualTo(2);
    }



}
