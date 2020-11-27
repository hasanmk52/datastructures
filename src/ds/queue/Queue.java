package ds.queue;

/**
 * @author hasankagalwala on 8/26/18
 * @project datastructures
 */
public class Queue {

    private int maxSize; //initializes the set number of slots
    private long[] queueArray; //slots to maintain the data
    private int front; //this will be the index position of the element in front of line
    private int rear; //this will be the index position of the element at back of line
    private int nItems; //counter to maintain the number of items in our queue

    public Queue(int size) {
        this.maxSize = size;
        this.queueArray = new long[size];
        front = 0; //index position of the first slot of array
        rear = -1; //there is no item in the array yet to be considered as the last item
        nItems = 0; //we don't have any elements in the array yet
    }

    public void insert(long j) {
        if(rear == maxSize -1) {
            rear = -1; //this will overwrite existing element(s) when array is full. This kind of implementation of Queue is called Circular Queue.
        }
        rear++;
        queueArray[rear] = j;
        nItems++;
    }

    public long remove() { //remove item from front of the queue
        long temp = queueArray[front];
        front++;
        if(front == maxSize) {
            front = 0; //we can set front back to the 0th index so that we can utilize the entire array again
        }
        nItems--;
        return temp;
    }

    public long peekFront() {
        return queueArray[front];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public void view() {
        System.out.print("[ ");
        for (int i=0; i < queueArray.length; i++) {
            System.out.print(queueArray[i]+ " ");
        }
        System.out.print("]");
    }

}
