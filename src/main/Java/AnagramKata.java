import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramKata {
    public static Scanner s;

    public AnagramKata(String path) throws FileNotFoundException {
        File wordList = new File(path);
        s = new Scanner(wordList);
    }

    public Integer returnsNumberOfAnagrams(String word) throws FileNotFoundException {
        Integer totalNumber = 0;
        while (s.hasNext()) {
            totalNumber += checksWordsForAnagram(s.next(), word);
            //System.out.println(s.next());
        }
        s.close();
        return totalNumber;
    }



    public Integer checksWordsForAnagram(String wordToCheck, String secondWordToCheck) throws FileNotFoundException {
        if (splitIntoSet(wordToCheck.toLowerCase().replaceAll("[^a-z]", "")).equals(splitIntoSet(secondWordToCheck.toLowerCase().replaceAll("[^a-z]", "")))) {
            return 1;
        }
        return 0;
    }

    public Map splitIntoSet(String wordToGoIntoSet) {
        Map<Character, Integer> splitWord = new HashMap();
        for (int i = 0; i < wordToGoIntoSet.length(); i++) {
            Integer valueForCharacter = 1;

            if (splitWord.get(wordToGoIntoSet.charAt(i)) != null) {
                valueForCharacter = splitWord.get(wordToGoIntoSet.charAt(i)) + 1;
            }
            splitWord.put(wordToGoIntoSet.charAt(i), valueForCharacter);
        }

        return splitWord;
    }






    //don't need this
//    public String readsEachWordIndividually() throws FileNotFoundException {
//        return s.next();
//    }
}
