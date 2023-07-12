package CodingBat;

public class StarOut {

    public static String starOut(String str) {
        return str.replaceAll(".[*]+.|[*]+.|.[*]+|[*]+", "");
    }
}
