package LeetCode;

public class _1_TwoSum {
    public static void main(String[] args) {

    }

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they
    add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element
    twice.

    You can return the answer in any order.
     */

    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        boolean isEqual = false;
        for (int i = 0; i < nums.length - 1; i++) {
            int firstElement = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                int secondElement = nums[j];

                if (firstElement + secondElement == target) {
                    indices[0] = i;
                    indices[1] = j;
                    isEqual = true;
                    break;
                }
            }

            if (isEqual) {
                break;
            }
        }
        return indices;
    }
}
