import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 32, 19, 303, 304, 80398, 809844, 93, 1, 2, 3};

        // Array before selection sort
        System.out.println(Arrays.toString(array));

        selectionSort(array);

        // Array after selection sort
        System.out.println(Arrays.toString(array));
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int smallest = array[i];
            int index = i;

            for (int j = i + 1; j < array.length; j++) {
                int element = array[j];

                if (element < smallest) {
                    smallest = element;
                    index = j;
                }
            }

            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }
}

