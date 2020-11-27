package ds.arrays;

import java.util.Arrays;

/**
 * @author hasankagalwala on 5/15/20
 * @project datastructures
 *
 * Find the longest common prefix in an array of strings
 *
 * A prefix is a collection of characters at the beginning of a string.
 * For instance, “mi” is a prefix of “mint” and the longest common prefix between “mint”, “mini”, and “mineral” is “min”.
 *
 * Algorithm:
 * 1.) Sort the array of strings in alphabetical order.
 *
 * 2.) Compare the characters in the first and last strings in the array. Since the array is sorted,
 *     common characters among the first and last element will be common among all the elements of the array.
 *
 *  2.1. If they are same, then append the character to the result.
 *
 *  2.2. Else, stop the comparison – result contains the longest common prefix among the strings in the array.
 */
public class LongestCommonPrefix {

    public static void main(String args[]) {
        String[] arr = {"mint", "mini", "mineral"};
        int size = arr.length;
        // The longest common prefix of an empty array is "".
        if (size == 0) {
            System.out.println("Longest common prefix: ");
        }
        // The longest common prefix of an array containing
        // only one element is that element itself.
        else if (size == 1) {
            System.out.println("Longest common prefix: " + arr[0]);
        } else {
            // Sort the array
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));
            int length = arr[0].length();
            StringBuilder res = new StringBuilder();
            // Compare the first and the last strings character
            // by character.
            for (int i = 0; i < length; i++) {
                // If the characters match, append the character to the result.
                if (arr[0].charAt(i) == arr[size - 1].charAt(i)) {
                    res.append(arr[0].charAt(i));
                }
                // Else, stop the comparison.
                else {
                    break;
                }
            }
            String result = res.toString();
            System.out.println("Longest common prefix: " + result);
        }
    }

}