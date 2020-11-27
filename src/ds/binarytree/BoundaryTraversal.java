package ds.binarytree;

/**
 * @author hasankagalwala on 5/13/20
 * @project datastructures
 *
 * Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root. The boundary includes left boundary, leaves,
 * and right boundary in order without duplicate nodes. (The values of the nodes may still be duplicates.)
 *
 * The left boundary is defined as the path from the root to the left-most node. The right boundary is defined as the path from the root to the
 * right-most node. If the root doesn’t have left subtree or right subtree, then the root itself is left boundary or right boundary.
 * Note this definition only applies to the input binary tree, and not apply to any subtrees.
 *
 * The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if it exists.
 * If not, travel to the right subtree. Repeat until you reach a leaf node.
 * The right-most node is also defined in the same way with left and right exchanged.
 *
 * We break the problem in 3 parts:
 * 1. Print the left boundary in top-down manner.
 * 2. Print all leaf nodes from left to right, which can again be sub-divided into two sub-parts:
 * …..2.1 Print all leaf nodes of left sub-tree from left to right.
 * …..2.2 Print all leaf nodes of right subtree from left to right.
 * 3. Print the right boundary in bottom-up manner.
 *
 * We need to take care of one thing that nodes are not printed again. e.g. The left most node is also the leaf node of the tree.
 *
 */
public class BoundaryTraversal {

    static class Node {
        int data;
        Node left, right;
        Node(int v)
        {
            data = v;
            left = null;
            right = null;
        }
    }
    Node root;

    // A simple function to print leaf nodes of a binary tree
    void printLeaves(Node node) {
        if (node == null)
            return;

        printLeaves(node.left);
        // Print it if it is a leaf node
        if (node.left == null && node.right == null)
            System.out.print(node.data + " ");
        printLeaves(node.right);
    }

    // A function to print all left boundary nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    void printBoundaryLeft(Node node) {
        if (node == null)
            return;

        if (node.left != null) {
            // to ensure top down order, print the node
            // before calling itself for left subtree
            System.out.print(node.data + " ");
            printBoundaryLeft(node.left);
        }
        else if (node.right != null) {
            System.out.print(node.data + " ");
            printBoundaryLeft(node.right);
        }

        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    // A function to print all right boundary nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    void printBoundaryRight(Node node) {
        if (node == null)
            return;

        if (node.right != null) {
            // to ensure bottom up order, first call for right
            // subtree, then print this node
            printBoundaryRight(node.right);
            System.out.print(node.data + " ");
        }
        else if (node.left != null) {
            printBoundaryRight(node.left);
            System.out.print(node.data + " ");
        }
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    // A function to do boundary traversal of a given binary tree
    void printBoundary(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");

        // Print the left boundary in top-down manner.
        printBoundaryLeft(node.left);

        // Print all leaf nodes
        printLeaves(node.left);
        printLeaves(node.right);

        // Print the right boundary in bottom-up manner
        printBoundaryRight(node.right);
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        BoundaryTraversal bt = new BoundaryTraversal();
        bt.root = new Node(20);
        bt.root.left = new Node(8);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(12);
        bt.root.left.right.left = new Node(10);
        bt.root.left.right.right = new Node(14);
        bt.root.right = new Node(22);
        bt.root.right.right = new Node(25);
        bt.printBoundary(bt.root);
    }

}
