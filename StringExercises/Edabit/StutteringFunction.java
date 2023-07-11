package Edabit;

public class StutteringFunction {
    public static void main(String[] args) {

    }

    public static String stutter(String word) {
        return word.substring(0, 2).concat("..").repeat(2).concat(" ").concat(word).concat("?");
    }
}
