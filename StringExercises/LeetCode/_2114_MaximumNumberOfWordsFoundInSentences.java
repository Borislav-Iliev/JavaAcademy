package LeetCode;

public class _2114_MaximumNumberOfWordsFoundInSentences {

    public int mostWordsFound(String[] sentences) {
        int biggest = Integer.MIN_VALUE;
        for (String sentence : sentences) {
            String[] tokens = sentence.split(" ");
            if (tokens.length > biggest) {
                biggest = tokens.length;
            }
        }

        return biggest;
    }
}
