package ds.arrays;

/**
 * @author hasankagalwala on 10/14/20
 * @project datastructures
 * Given an array of integers, find the second largest element present in the array.
 * Input: arr[] = {12, 35, 1, 10, 34, 1}
 * Output: The second largest element is 34.
 * Algorithm:
 *
 * 1) Initialize two variables first and second to INT_MIN as
 *    first = second = INT_MIN
 * 2) Start traversing the array,
 *    a) If the current element in array say arr[i] is greater
 *       than first. Then update first and second as,
 *       second = first
 *       first = arr[i]
 *    b) If the current element is in between first and second,
 *       then update second to store the value of current variable as
 *       second = arr[i]
 * 3) Return the value stored in second.
 */
public class SecondHighestNumber {

    public static void main(String[] args) throws Exception {
        int arr[] = { 12, 35, 1, 10, 34, 1 };
        System.out.println(findSecondLargest(arr));
    }

    public static int findSecondLargest(int arr[]) throws Exception {

        if (arr.length < 2) {
            throw new IllegalArgumentException("Invalid Input");
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            /* If current element is greater than first then update both first and second */
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            }

            /* If arr[i] is in between first and second then update second  */
            else if (arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }

        if (second == Integer.MIN_VALUE) {
            System.out.println("There is no second largest element");
            return -1;
        }
        else {
            return second;
        }
    }
}
