import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 9, 891, 81, 0, 25};

        // Array before merge sort
        System.out.println(Arrays.toString(array));

        mergeSort(array);

        // Array after merge sort
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array) {
        int length = array.length;

        if (length < 2) {
            return;
        }

        int midIndex = length / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[length - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = array[i];
        }

        for (int i = midIndex; i < length; i++) {
            rightHalf[i - midIndex] = array[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(array, leftHalf, rightHalf);
    }

    private static void merge(int[] array, int[] leftHalf, int[] rightHalf) {
        int leftLength = leftHalf.length;
        int rightLength = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while (i < leftLength && j < rightLength) {
            if (leftHalf[i] <= rightHalf[j]) {
                array[k] = leftHalf[i];
                i++;
            } else {
                array[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            array[k] = leftHalf[i];
            k++;
            i++;
        }

        while (j < rightLength) {
            array[k] = rightHalf[j];
            k++;
            j++;
        }
    }
}
