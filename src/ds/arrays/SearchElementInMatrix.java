package ds.arrays;

/**
 * @author hasankagalwala on 9/25/20
 * @project datastructures
 *
 * Given an n x n matrix and a number x, find the position of x in the matrix if it is present in it and print its position.
 * Assume every row and column is sorted in increasing order.
 * Input: mat[4][4] = { {10, 20, 30, 40},
 *                       {15, 25, 35, 45},
 *                       {27, 29, 37, 48},
 *                       {32, 33, 39, 50}};
 *               x = 29
 * Output: Found at (2, 1)
 * Explanation: Element at (2,1) is 29
 *
 * Approach: The simple idea is to remove a row or column in each comparison until an element is found. Start searching from the top-right corner of the matrix. There are three possible cases.
 * The given number is greater than the current number: This will ensure, that all the elements in the current row are smaller than the given number as the pointer is already at the right-most element and the row is sorted. Thus, the entire row gets eliminated and continue the search on the next row. Here elimination means that row needs not to be searched.
 * The given number is smaller than the current number: This will ensure, that all the elements in the current column are greater than the given number. Thus, the entire column gets eliminated and continue the search on the previous column i.e. the column at the immediate left.
 * The given number is equal to the current number: This will end the search.
 * The search can also be started from the bottom left corner of the matrix.
 *
 * Algorithm:
 * Let the given element be x, create two variable i = 0, j = n-1 as index of row and column
 * Run a loop until i = 0
 * Check if the current element is greater than x then decrease the count of j. Exclude the current column.
 * Check if the current element is less than x then increase the count of i. Exclude the current row.
 * If the element is equal then print the position and end.
 */
public class SearchElementInMatrix {

    private static void search(int[][] mat, int n, int x) {

        int i = 0, j = n - 1; // set indexes for top right element

        while (i < n && j >= 0) {
            if (mat[i][j] == x) {
                System.out.print("n Found at " + i + " " + j);
                return;
            }
            if (x < mat[i][j]) {
                j--;
            }
            else {
                i++;
            }
        }

        System.out.print("n Element not found");
        return; // if ( i==n || j== -1 )
    }

    public static void main(String[] args) {
        int mat[][] = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};
        search(mat, 4, 29);
    }

}
