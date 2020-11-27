package ds.stack;

import java.util.Stack;

/**
 * @author hasankagalwala on 5/25/20
 * @project datastructures
 *
 * Given an expression string exp , write a program to examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]”
 * are correct in exp.
 *
 * Example:
 *
 * Input: exp = “[()]{}{[()()]()}”
 * Output: true
 *
 * Input: exp = “[(])”
 * Output: false
 *
 * Algorithm:
 *
 * Declare a character stack S.
 * Now traverse the expression string exp.
 * If the current character is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push it to stack.
 * If the current character is a closing bracket (‘)’ or ‘}’ or ‘]’) then pop from stack and if the popped character is the
 * matching starting bracket then fine else parenthesis are not balanced.
 * After complete traversal, if there is some starting bracket left in stack then “not balanced”
 */
public class BalancedParanthesis {

    public static void main(String[] args) {
        System.out.println(isBalanced("{}()"));
        System.out.println(isBalanced("{()}"));
        System.out.println(isBalanced("{}("));
    }

    private static boolean isBalanced(String expression) {

        if ((expression.length() % 2) == 1) return false;
        else {
            Stack<Character> s = new Stack<>();
            for (char bracket : expression.toCharArray())
                switch (bracket) {
                    case '{': s.push('}'); break;
                    case '(': s.push(')'); break;
                    case '[': s.push(']'); break;
                    default :
                        if (s.isEmpty() || bracket != s.peek()) { return false;}
                        s.pop();
                }
            return s.isEmpty();
        }
    }
}
