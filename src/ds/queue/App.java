package ds.queue;

import ds.stack.Stack;

/**
 * @author hasankagalwala on 8/24/18
 * @project datastructures
 */
public class App {

    public static void main(String[] args) {
        Queue myQueue = new Queue(5);
        myQueue.insert(100);
        myQueue.insert(130);
        myQueue.insert(1020);
        myQueue.insert(104);
        myQueue.insert(107);
        myQueue.insert(33);
        myQueue.view();
    }


}
