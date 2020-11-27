package ds.binarytree;

/**
 * @author hasankagalwala on 11/25/20
 * @project datastructures
 *
 * Return the diameter of the Binary tree. The diameter is defined as the length of its longest path, even if that path doesn't pass
 * through the root of the tree.
 * A path is the collection of connected nodes in a tree, where no node is connected to more than two other nodes. The length of the
 * path is the number of edges between the path's first node and it's last node.
 */
public class DiameterOfTree {

    //O(n) time and O(h) space where n is no of nodes and h is height of tree
    int max = 0;

    public int binaryTreeDiameter(BinaryTree tree) {
        helper(tree);
        return max;
    }

    private int helper(BinaryTree root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = helper(root.left);
        int rightDepth = helper(root.right);

        max = Math.max(max, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
