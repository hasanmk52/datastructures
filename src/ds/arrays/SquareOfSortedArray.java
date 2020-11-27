package ds.arrays;

/**
 * @author hasankagalwala on 11/26/20
 * @project datastructures
 *
 * Sort array after converting elements to their squares
 *
 * Input  : arr[] =  {-6, -3, -1, 2, 4, 5}
 * Output : 1, 4, 9, 16, 25, 36
 *
 * Efficient solution is based on the two-pointer method as the array is already sorted we can compare the first and last element to check which is bigger and proceed with the result.
 *
 * Algorithm –
 *
 * Initialize left=0 and right=n-1
 * if abs(left) >= abs(right) then store square(arr[left])
 * at the end of result array and increment left pointer
 * else store square(arr[right]) in the result array and decrement right pointer
 * decrement index of result array
 */
public class SquareOfSortedArray {

    // Function to sort an square array
    public static void sortSquares(int arr[]) {

        int n = arr.length, left = 0, right = n - 1;

        int result[] = new int[n];

        for(int index = n - 1; index >= 0; index--) {
            if (Math.abs(arr[left]) > arr[right]) {
                result[index] = arr[left] * arr[left];
                left++;
            }
            else {
                result[index] = arr[right] * arr[right];
                right--;
            }
        }
        for(int i = 0; i < n; i++)
            arr[i] = result[i];
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = { -6, -3, -1, 2, 4, 5 };
        int n = arr.length;

        System.out.println("Before sort ");
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        sortSquares(arr);
        System.out.println("");
        System.out.println("After Sort ");
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
