package ds;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hasankagalwala on 5/8/20
 * @project datastructures
 *
 * Users on longer flights like to start a second movie right when their first one ends, but they complain that the plane usually lands before they can
 * see the ending. So you're building a feature for choosing two movies whose total runtimes will equal the exact flight length.
 *
 * Write a method that takes an integer flightLength (in minutes) and an array of integers movieLengths (in minutes) and returns a boolean indicating
 * whether there are two numbers in movieLengths whose sum equals flightLength.
 *
 * When building your method:
 *
 * Assume your users will watch exactly two movies
 * Don't make your users watch the same movie twice
 * Optimize for runtime over memory
 *
 *
 * We make one pass through movieLengths, treating each item as the firstMovieLength. At each iteration, we:
 *
 * See if there's a matchingSecondMovieLength we've seen already (stored in our movieLengthsSeen hash set) that is equal to flightLength - firstMovieLength.
 * If there is, we short-circuit and return true.
 * Keep our movieLengthsSeen hash set up to date by throwing in the current firstMovieLength.
 */
public class InFlightEntertainment {

    public static boolean canTwoMoviesFillFlight(int[] movieLengths, int flightLength) {

        // movie lengths we've seen so far
        Set<Integer> movieLengthsSeen = new HashSet<>();

        for (int firstMovieLength : movieLengths) {

            int matchingSecondMovieLength = flightLength - firstMovieLength;
            if (movieLengthsSeen.contains(matchingSecondMovieLength)) {
                return true;
            }

            movieLengthsSeen.add(firstMovieLength);
        }

        // we never found a match, so return false
        return false;

        //Complexity
        //O(n) time, and O(n) space. Note while optimizing runtime we added a bit of space cost.
    }
}
