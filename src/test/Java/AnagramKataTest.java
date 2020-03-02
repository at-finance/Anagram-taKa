import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileNotFoundException;

public class AnagramKataTest {

   // @Test
//    @Ignore
//    public void txtFile_isReturnedOneWordAtATime() throws FileNotFoundException {
//        AnagramKata anagramKata = new AnagramKata("/Users/april.peace/Projects/Anagram-taKa/src/main/resources/wordlist.txt");
//        Assertions.assertThat(anagramKata.readsEachWordIndividually()).contains("A");
//        Assertions.assertThat(anagramKata.readsEachWordIndividually()).contains("A'asia");
//        Assertions.assertThat(anagramKata.readsEachWordIndividually()).contains("A's");
//
//        anagramKata.s.close();
//
//    }

    @Test
    public void txtFileWordsWithNoDuplicates_AreSplitIntoSets() throws FileNotFoundException {
        AnagramKata anagramKata = new AnagramKata("/Users/april.peace/Projects/Anagram-taKa/src/main/resources/wordlist.txt");
        Assertions.assertThat(anagramKata.splitIntoSet("jakl")).containsKeys('j', 'k', 'l', 'a');
    }

    @Test
    public void txtFileWordsWithDuplicates_AreSplitIntoSets() throws FileNotFoundException {
        AnagramKata anagramKata = new AnagramKata("/Users/april.peace/Projects/Anagram-taKa/src/main/resources/wordlist.txt");
        Assertions.assertThat(anagramKata.splitIntoSet("jakkl")).containsKeys('j', 'k', 'l', 'a').containsValue(2);

    }

    @Test
    public void txtFile_checkWordsForAnagram_returns1WhenAnagram() throws FileNotFoundException {
        AnagramKata anagramKata = new AnagramKata("/Users/april.peace/Projects/Anagram-taKa/src/main/resources/wordlist.txt");
        String word1 = "lolm";
        String word2 = "mlol";
        Assertions.assertThat(anagramKata.checksWordsForAnagram(word1, word2)).isEqualTo(1);
    }

    @Test
    public void txtFile_checkWordsForAnagram_returns0WhenNoAnagram() throws FileNotFoundException
        {
        AnagramKata anagramKata = new AnagramKata("/Users/april.peace/Projects/Anagram-taKa/src/main/resources/wordlist.txt");
        String word1 = "lollm";
        String word2 = "mlol";
        Assertions.assertThat(anagramKata.checksWordsForAnagram(word1, word2)).isEqualTo(0);
    }

    @Test
    public void returnsNumberOfAnagrams_returnsCorrectNumber_withNoSpecialCharacters() throws FileNotFoundException {
        AnagramKata anagramKata = new AnagramKata("/Users/april.peace/Projects/Anagram-taKa/src/main/resources/wordlisttest.txt");
        Assertions.assertThat(anagramKata.returnsNumberOfAnagrams("act")).isEqualTo(2);
    }

    @Test
    public void returnsNumberOfAnagrams_returnsCorrectNumber_withSpecialCharacters() throws FileNotFoundException {
        AnagramKata anagramKata = new AnagramKata("/Users/april.peace/Projects/Anagram-taKa/src/main/resources/wordlisttest.txt");
        Assertions.assertThat(anagramKata.returnsNumberOfAnagrams("ac1&t")).isEqualTo(2);
    }



}
