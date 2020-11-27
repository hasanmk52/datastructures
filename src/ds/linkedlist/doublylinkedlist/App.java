package ds.linkedlist.doublylinkedlist;

/**
 * @author hasankagalwala on 9/26/18
 * @project datastructures
 */
public class App {

    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.insertFirst(100);
        myList.insertFirst(50);
        myList.insertFirst(99);
        myList.insertFirst(88);
        myList.insertLast(999);
        myList.insertLast(967);
        myList.displayForward();
        myList.displayBackword();
        myList.deleteFirst();
        myList.deleteLast();
        myList.deleteKey(99);
        myList.insertAfter(999, 34);
        myList.insertAfter(967, 12);
        myList.displayForward();
    }
}
