package ds.linkedlist;

/**
 * @author hasankagalwala on 5/8/20
 * @project datastructures
 *
 * Write a method for reversing a linked list. Do it in place.
 *
 * Your method will have one input: the head of the list.
 *
 * Your method should return the new head of the list.
 *
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        Node[] nodes = valuesToNodes(new int[] {1, 2, 3, 4, 5, 6});
        System.out.println(reverse(nodes[0]));
    }

    private static Node[] valuesToNodes(int[] values) {
        Node[] nodes = new  Node[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Node();
            nodes[i].data = values[i];
            if (i > 0) {
                nodes[i - 1].next = nodes[i];
            }
        }
        return nodes;
    }

    public static Node reverse(Node headOfList) {
        Node currentNode = headOfList;
        Node previousNode = null;
        Node nextNode;

        // until we have 'fallen off' the end of the list
        while (currentNode != null) {

            // copy a pointer to the next element
            // before we overwrite currentNode.next
            nextNode = currentNode.next;

            // reverse the 'next' pointer
            currentNode.next = previousNode;

            // step forward in the list
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return previousNode;
    }
    //Complexity
    //O(n) time and O(1) space. We pass over the list only once, and maintain a constant number of variables in memory
}
