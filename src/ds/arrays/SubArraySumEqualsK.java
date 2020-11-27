package ds.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hasankagalwala on 10/14/20
 * @project datastructures
 *
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum
 * equals to k.
 *
 * Example 1:
 *
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 *
 * We make use of a hashmap map which is used to store the cumulative sum upto all the indices possible along
 * with the number of times the same sum occurs.
 * We store the data in the form: (sum , no.ofoccurencesofsum).
 * We traverse over the array nums and keep on finding the cumulative sum.
 * Every time we encounter a new sum, we make a new entry in the hashmap corresponding to that sum.
 * If the same sum occurs again, we increment the count corresponding to that sum in the hashmap.
 * Further, for every sum encountered, we also determine the number of times the sum sum−k has occurred already,
 * since it will determine the number of times a subarray with sum k has occured upto the current index.
 * We increment the count by the same amount.
 * After the complete array has been traversed, the count gives the required result.
 */
public class SubArraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int result = 0;

        Map<Integer, Integer> arrSums = new HashMap<>();
        arrSums.put(0, 1);
        for(int i=0; i < nums.length; i++) {
            sum += nums[i];
            if(arrSums.containsKey(sum - k)) {
                result += arrSums.get(sum - k);
            }
            arrSums.put(sum, arrSums.getOrDefault(sum, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(arr, k));
    }
}
