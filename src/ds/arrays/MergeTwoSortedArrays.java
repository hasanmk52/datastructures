package ds.arrays;

import java.util.Arrays;

/**
 * @author hasankagalwala on 5/7/20
 * @project datastructures
 *
 * First, we allocate our answer array, getting its size by adding the size of myArray and alicesArray.
 *
 * We keep track of a current index in myArray, a current index in alicesArray, and a current index in mergedArray.
 * So at each step, there's a "current item" in alicesArray and in myArray. The smaller of those is the next one we add to the mergedArray!
 *
 * But careful: we also need to account for the case where we exhaust one of our arrays and there are still elements in the other.
 * To handle this, we say that the current item in myArray is the next item to add to mergedArray only if myArray is not exhausted AND, either:
 * alicesArray is exhausted, or the current item in myArray is less than the current item in alicesArray
 */
public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int[] myArray = new int[]{3, 4, 6, 10, 11, 15};
        int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};
        System.out.println(Arrays.toString(mergeArrays(myArray,alicesArray)));
    }

    public static int[] mergeArrays(int[] myArray, int[] alicesArray) {

        // set up our mergedArray
        int[] mergedArray = new int[myArray.length + alicesArray.length];

        int currentIndexAlices = 0;
        int currentIndexMine   = 0;
        int currentIndexMerged = 0;

        while (currentIndexMerged < mergedArray.length) {

            boolean isMyArrayExhausted = currentIndexMine >= myArray.length;
            boolean isAlicesArrayExhausted = currentIndexAlices >= alicesArray.length;

            // case: next comes from my array
            // my array must not be exhausted, and EITHER:
            // 1) Alice's array IS exhausted, or
            // 2) the current element in my array is less
            //    than the current element in Alice's array
            if (!isMyArrayExhausted && (isAlicesArrayExhausted
                    || (myArray[currentIndexMine] < alicesArray[currentIndexAlices]))) {

                mergedArray[currentIndexMerged] = myArray[currentIndexMine];
                currentIndexMine++;

                // case: next comes from Alice's array
            } else {
                mergedArray[currentIndexMerged] = alicesArray[currentIndexAlices];
                currentIndexAlices++;
            }

            currentIndexMerged++;
        }

        return mergedArray;
    }
}
