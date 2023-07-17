package Edabit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TripleLetterGroupings {

    /*
    Given a string, return a sorted array of words formed from the first three letters, then the
    next three letters, shifting by only one.
     */

    public static String[] threeLetterCollection(String s) {
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length() - 2; i++) {
            char firstCharacter = s.charAt(i);
            char secondCharacter = s.charAt(i + 1);
            char thirdCharacter = s.charAt(i + 2);

            sb.append(firstCharacter).append(secondCharacter).append(thirdCharacter);

            words.add(sb.toString());
            sb.setLength(0);
        }

        Collections.sort(words);
        return words.toArray(new String[0]);
    }
}
