package ds.arrays;

import java.util.*;

/**
 * @author hasankagalwala on 5/13/20
 * @project datastructures
 *
 * Given a list of points on the 2-D plane and an integer K. The task is to find K closest points to the origin and print them.
 *
 * Note: The distance between two points on a plane is the Euclidean distance.The euclidean distance between these two points will be:
 * √{(x2-x1)2 + (y2-y1)2}
 *
 * Input : point = [[3, 3], [5, -1], [-2, 4]], K = 2
 * Output : [[3, 3], [-2, 4]]
 * Explanation:
 * Square of Distance of origin from this point is
 * (3, 3) = 18
 * (5, -1) = 26
 * (-2, 4) = 20
 * So rhe closest two points are [3, 3], [-2, 4].
 *
 * Input : point = [[1, 3], [-2, 2]], K  = 1
 * Output : [[-2, 2]]
 * Explanation:
 * Square of Distance of origin from this point is
 * (1, 3) = 10
 * (-2, 2) = 8
 * So the closest point to origin is (-2, 2)
 *
 * We need to find the k closest points. The best way to achieve this would be to use PriorityQueue.
 * It would give us K closest distance. But we need a mapping between distance and the point. This mapping can be used by using HashMap.
 *
 */
public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        int[][] output = kClosestPointsToOrigin.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i][0] + "," + output[i][1]);
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        HashMap<Double, List<Integer>> map = new HashMap<>();
        Queue<Double> pq = new PriorityQueue<>();
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            Double distance = Math.sqrt((p[1] - 0) * (p[1] - 0) + (p[0] - 0) * (p[0] - 0));
            map.compute(distance, (k, v) -> v == null ? new ArrayList<>() : v).add(i);
            pq.add(distance);
        }
        System.out.println(map);
        int[][] result = new int[K][2];
        int i = 0;
        while (!pq.isEmpty() && i < K) {
            List<Integer> pos = map.get(pq.poll());
            for (int j : pos) {
                result[i++] = points[j];
            }
        }
        return result;
    }
}
