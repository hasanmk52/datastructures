package ds.linkedlist.singlylinkedlist;

/**
 * @author hasankagalwala on 8/28/18
 * @project datastructures
 */
public class SinglyLinkedList {

    private Node first;

    public SinglyLinkedList() {}

    public boolean isEmpty() {
        return (first == null);
    }

    //used to insert at the beginning of the list
    public void insertFirst(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = first;//new node is now pointing to the previous first node(which is now second)
        first = newNode;//the new node becomes the first node
    }

    public Node deleteFirst() {
        Node temp = first;
        first = first.next; //removing the reference from the earlier pointed node to new node
        return temp;
    }

    public void displayList() {
        System.out.println("List (first --> last) ");
        Node current = first;
        while(current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }

    public void insertLast(int data) {
        Node current = first;
        while(current.next != null) {
            current = current.next; //we'll loop until current.next is null
        }
        Node newNode = new Node();
        newNode.data = data;
        current.next = newNode;
    }
}
