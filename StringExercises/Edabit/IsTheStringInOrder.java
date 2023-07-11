package Edabit;

public class IsTheStringInOrder {
    public static void main(String[] args) {
        System.out.println(isInOrder("abc"));
        System.out.println(isInOrder("edabit"));
    }

    public static boolean isInOrder(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            char firstCharacter = str.charAt(i);
            char secondCharacter = str.charAt(i + 1);

            if (firstCharacter > secondCharacter) {
                return false;
            }
        }
        return true;
    }
}
