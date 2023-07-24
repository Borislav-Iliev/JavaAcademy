package CustomList;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<Integer> customList = new CustomArrayList<>();

        System.out.println(customList);

        customList.add(1);
        customList.add(3);
        customList.add(1);
        customList.add(9);
        customList.add(25);
        customList.add(18);
        customList.add(90);
        System.out.println(customList);
        System.out.println(customList.size());

//        customList.add(5, 9);
//        System.out.println(customList);
//        System.out.println(customList.size());

        customList.remove(Integer.valueOf(18));
        System.out.println(customList);
        System.out.println(customList.size());

        customList.remove(5);
        System.out.println(customList);
        System.out.println(customList.size());

//        customList.clear();
//        System.out.println(customList);
//        System.out.println(customList.size());

        System.out.println(customList.get(1));

        System.out.println(customList.isEmpty());

        System.out.println(customList.indexOf(1));
        System.out.println(customList.indexOf(0));

        System.out.println(customList.lastIndexOf(1));
        System.out.println(customList.lastIndexOf(0));

        System.out.println(customList.contains(1));
        System.out.println(customList.contains(0));

        CustomArrayList<Integer> customArrayList1 = new CustomArrayList<>();
        customArrayList1.add(1);
        customArrayList1.add(8);
        customList.addAll(customArrayList1);
        System.out.println(customList);
        System.out.println(customList.size());

        CustomArrayList<Integer> customArrayList2 = new CustomArrayList<>();
        customArrayList2.add(1);
        customArrayList2.add(8);
        System.out.println(customList.containsAll(customArrayList2));
    }
}
