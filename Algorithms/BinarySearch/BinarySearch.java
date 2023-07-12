public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 4, 5, 9, 11, 25};

        // Example with element present in the array iterative should return index of element
        System.out.println(binarySearchIterative(array, 25));

        // Example with element not present in the array iterative should return -1
        System.out.println(binarySearchIterative(array, 90));

        // Example with element present in the array recursive should return index of element
        System.out.println(binarySearchRecursive(array, 25, 0, array.length -1));

        // Example with element not present in the array recursive should return -1
        System.out.println(binarySearchRecursive(array, 90, 0, array.length - 1));
    }

    // Binary Search Iterative Method
    private static int binarySearchIterative(int[] array, int numberToFind) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;

            if (numberToFind > array[middle]) {
                low = middle + 1;
            } else if (numberToFind < array[middle]) {
                high = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    // Binary Search With Recursion
    private static int binarySearchRecursive(int[] array, int numberToFind, int low, int high) {
        int middle = (low + high) / 2;

        if (high < low) {
            return -1;
        }

        if (numberToFind > array[middle]) {
            return binarySearchRecursive(array, numberToFind, middle + 1, high);
        } else if (numberToFind < array[middle]) {
            return binarySearchRecursive(array, numberToFind, low, middle - 1);
        } else {
            return middle;
        }
    }
}
