package ds.arrays;

/**
 * @author hasankagalwala on 5/28/20
 * @project datastructures
 *
 * It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride! There are a number of people queued up, and each person wears a sticker indicating their initial position in the queue.
 * Initial positions increment by  from  at the front of the line to  at the back.
 *
 * Any person in the queue can bribe the person directly in front of them to swap positions. If two people swap positions,
 * they still wear the same sticker denoting their original places in line. One person can bribe at most two others.
 *
 * Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took place to get the queue into its current state!
 *
 * Complete the function minimumBribes in the editor below. It must print an integer representing the minimum number of bribes necessary,
 * or 'Too chaotic' if the line configuration is not possible.
 *
 * minimumBribes has the following parameter(s):
 *
 * q: an array of integer
 */
public class NewYearChaos {

    public static void main(String[] args) {
        int[] arr = {2,1,5,3,4};
        minimumBribes(arr);
    }

    private static void minimumBribes(int[] queue) {
        boolean chaotic = false;
        int bribes = 0;
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] - (i+1) > 2) {
                chaotic = true;
                break;
            }
            //Since if one person bribes more than twice, it would simply return “Too chaotic”, you don't actually have to check
            // every single value, we can narrow down by changing the value of j to queue[i]-2.
            int j = Math.max(0,queue[i]-2);
            while(j < i) {
                if (queue[j] > queue[i]) {
                    bribes++;
                }
                j++;
            }
        }
        if(chaotic){
            System.out.println("Too chaotic");
        } else {
            System.out.println(bribes);
        }
    }
}
