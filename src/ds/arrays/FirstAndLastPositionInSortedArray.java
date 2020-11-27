package ds.arrays;

import java.util.Arrays;

/**
 * @author hasankagalwala on 10/14/20
 * @project datastructures
 * https://www.youtube.com/watch?v=bU-q1OJ0KWw
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1]
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 */
public class FirstAndLastPositionInSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findStartingIndex(nums, target);
        result[1] = findEndingIndex(nums, target);
        return result;
    }

    public static int findStartingIndex(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int midpoint = start + (end - start) / 2;
            if(nums[midpoint] >= target) {
                end = midpoint - 1;
            } else {
                start = midpoint + 1;
            }
            if(nums[midpoint] == target) {
                index = midpoint;
            }
        }
        return index;
    }

    public static int findEndingIndex(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int midpoint = start + (end - start) / 2;
            if(nums[midpoint] <= target) {
                start = midpoint + 1;
            } else {
                end = midpoint - 1;
            }
            if(nums[midpoint] == target) {
                index = midpoint;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(arr, target)));
    }

}
