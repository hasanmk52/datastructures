package ds.stack;

/**
 * @author hasankagalwala on 8/24/18
 * @project datastructures
 */
public class App {

    public static void main(String[] args) {
        Stack theStack = new Stack(10);
        theStack.push('g');
        theStack.push('o');
        theStack.push('a');
        theStack.push('t');

        while (!theStack.isEmpty()) {
            char value = theStack.pop();
            System.out.println(value);
        }
        System.out.println(reverseString("hello"));

    }

    public static String reverseString(String str) {
        int stackSize = str.length();
        Stack theStack = new Stack(stackSize);
        for(int i = 0; i < stackSize; i++) {
            theStack.push(str.charAt(i));
        }
        String result="";
        while (!theStack.isEmpty()) {
            result = result + theStack.pop();
        }
        return result;
    }

}
