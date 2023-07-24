package CustomLinkedList;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<Integer>();
        customLinkedList.add(1);
        customLinkedList.add(8);
        customLinkedList.add(9);
        customLinkedList.add(9);
        customLinkedList.add(9);
        customLinkedList.add(0, 18);
        System.out.println(customLinkedList.size());
        System.out.println(customLinkedList);

//        customLinkedList.clear();
//        System.out.println(customLinkedList.size());
//        System.out.println(customLinkedList);

        System.out.println(customLinkedList.get(2));
    }
}
