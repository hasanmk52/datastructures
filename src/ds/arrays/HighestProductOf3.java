package ds.arrays;

import java.util.Arrays;

/**
 * @author hasankagalwala on 5/7/20
 * @project datastructures
 *
 * Given an array of integers, find the highest product you can get from three of the integers.
 * (The input arrayOfInts will always have at least three integers.)
 */
public class HighestProductOf3 {

    public static void main(String[] args) {
        int[] arrayOfInts = new int[]{1, 10, -5, 1, -100};
        System.out.println(highestProductOf3(arrayOfInts));
    }

    public static int highestProductOf3(int[] nums) {

        if (nums.length < 3) {
            throw new IllegalArgumentException("Less than 3 items!");
        }
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);

        /*Complexity Analysis

        Time complexity : O(nlogn). Sorting the nums array takes nlogn time.

        Space complexity : O(logn). Sorting takes O(logn) space.*/
    }
}
