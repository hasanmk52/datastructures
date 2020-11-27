package ds.stack;

/**
 * @author hasankagalwala on 8/24/18
 * @project datastructures
 */
public class Stack {

    private int maxSize;
    private char[] stackArray;
    private int top;//contains the index of the top most element

    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new char[size];
        this.top = -1; //initial value as no values inserted in the array yet.
    }

    public void push(char j) {
        if(isFull()) {
            System.out.println("This stack is already full!");
        } else {
            top++;
            stackArray[top] = j;
        }
    }

    public char pop() {
        if(isEmpty()) {
            System.out.println("This stack is already empty!");
            return '0';
        } else {
            int old_top = top;
            top--;
            return stackArray[old_top];
        }
    }

    public char peak() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (maxSize-1 == top);
    }
}
