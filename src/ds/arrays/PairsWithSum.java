package ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hasankagalwala on 10/16/20
 * @project datastructures
 * Given an array of integers, and a number ‘sum’, return a list of arrays whose sum is equal to ‘sum’
 * Examples :
 * Input  :  arr[] = {1, 5, 7, -1, 5},
 *           sum = 6
 * Output : [(1, 5) (7, -1) (1, 5)]
 */
public class PairsWithSum {

    public static List<int[]> pairedElements(int arr[], int sum) {
        List<int[]> result = new ArrayList<>();
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            if (arr[low] + arr[high] == sum) {
                result.add(new int[] {arr[low], arr[high]});
            }
            if (arr[low] + arr[high] > sum) {
                high--;
            }
            else {
                low++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, -2, 6, 8, 9, 11 };
        int sum = 6;
        Arrays.sort(arr);
        pairedElements(arr,sum);
    }
}
