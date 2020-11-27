package ds.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * @author hasankagalwala on 10/8/20
 * @project datastructures
 *
 * Delete duplicates from a sorted array and return the no of valid entries
 */
public class DeleteDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println(deleteDuplicates(Arrays.asList(2,3,5,7,7,11,11,11,13)));
    }

    public static int deleteDuplicates(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        } else if(list.size() == 1) {
            return 1;
        }
        int writeIndex = 1;
        for (int i = 1; i < list.size(); ++i) {
            if (!list.get(writeIndex - 1).equals(list.get(i))) {
                list.set(writeIndex, list.get(i));
                System.out.println(list);
                writeIndex++;
            }
        }
        return writeIndex;
    }
}
