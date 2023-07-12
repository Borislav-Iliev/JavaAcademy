package CodingBat;

public class GetSandwich {

    public String getSandwich(String str) {
        int firstIndex = str.indexOf("bread");
        int lastIndex = str.lastIndexOf("bread");

        if (firstIndex == lastIndex) {
            return "";
        }

        return str.substring(firstIndex + 5, lastIndex);
    }
}
