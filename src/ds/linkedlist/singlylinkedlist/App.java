package ds.linkedlist.singlylinkedlist;

/**
 * @author hasankagalwala on 9/7/18
 * @project datastructures
 */
public class App {

    public static void main(String[] args) {
        SinglyLinkedList myList = new SinglyLinkedList();
        myList.insertFirst(100);
        myList.insertFirst(50);
        myList.insertFirst(99);
        myList.insertFirst(88);
        myList.insertLast(999);

        myList.displayList();
    }
}
