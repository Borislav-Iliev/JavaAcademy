package CodingBat;

public class PrefixAgain {

    public boolean prefixAgain(String str, int n) {
        String prefix = str.substring(0, n);
        str = str.substring(n);
        return str.contains(prefix);
    }
}
