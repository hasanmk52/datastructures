package ds.binarytree;

import java.util.*;

/**
 * @author hasankagalwala on 5/2/20
 * @project datastructures
 *
 * Method 1: Check if a binary tree is superbalanced
 * Method 2: Check that a binary tree is a valid binary search tree.
 * Method 3: Find 2nd largest element in a binary search tree.
 */
public class BinaryTreeConcepts {

    /**
     * A tree is "superbalanced" if the difference between the depths of any two leaf nodes is no greater than one.
     *
     * we can simplify this requirement to require less work. For example, we could equivalently say:
     *      "The difference between the min leaf depth and the max leaf depth is 1 or less"
     *      "There are at most two distinct leaf depths, and they are at most 1 apart"
     *
     * We should use a traversal that will hit leaves as quickly as possible...
     * Depth-first traversal will generally hit leaves before breadth-first, so let's go with that.
     *
     *  Each time we hit a leaf with a new depth, there are two ways that our tree might now be unbalanced:
     *      There are more than 2 different leaf depths
     *      There are exactly 2 leaf depths and they are more than 1 apart.
     *  We chose depth-first because it reaches leaves faster, which allows us to short-circuit earlier and return false
     *  as soon as it finds two leaves with depths more than 1 apart.
     */
    public static boolean isBalanced(BinaryTreeNode treeRoot) {

        // a tree with no nodes is superbalanced, since there are no leaves!
        if (treeRoot == null) {
            return true;
        }

        // we short-circuit as soon as we find more than 2
        List<Integer> depths = new ArrayList<>(3);

        Deque<NodeDepthPair> nodes = new ArrayDeque<>();
        nodes.push(new NodeDepthPair(treeRoot, 0));

        while (!nodes.isEmpty()) {

            // pop a node and its depth from the top of our stack
            NodeDepthPair nodeDepthPair = nodes.pop();
            BinaryTreeNode node = nodeDepthPair.node;
            int depth = nodeDepthPair.depth;

            // case: we found a leaf
            if (node.left == null && node.right == null) {

                // we only care if it's a new depth
                if (!depths.contains(depth)) {
                    depths.add(depth);

                    // two ways we might now have an unbalanced tree:
                    //   1) more than 2 different leaf depths
                    //   2) 2 leaf depths that are more than 1 apart
                    if (depths.size() > 2 || (depths.size() == 2
                            && Math.abs(depths.get(0) - depths.get(1)) > 1)) {
                        return false;
                    }
                }
                // case: this isn't a leaf - keep stepping down
            } else {
                if (node.left != null) {
                    nodes.push(new NodeDepthPair(node.left, depth + 1));
                }
                if (node.right != null) {
                    nodes.push(new NodeDepthPair(node.right, depth + 1));
                }
            }
        }
        return true;
    }

    private static class NodeDepthPair {

        BinaryTreeNode node;
        int depth;

        NodeDepthPair(BinaryTreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    /**
     * A binary search tree is a binary tree where the nodes are ordered in a specific way. For every node:
     *      The nodes to the left are smaller than the current node.
     *      The nodes to the right are larger than the current node.
     * BSTs are sorted. Taking a binary search tree and pulling out all of the elements in sorted order can be done in O(n) using an in-order traversal.
     * Finding the element closest to a value can be done in O(log(n)) (again, if the BST is balanced!).
     *
     * One way to break the problem down is to come up with a way to confirm that a single node is in a valid place relative to its ancestors.
     * Then if every node passes this test, our whole tree is a valid BST.
     *
     * What makes a given node "correct" relative to its ancestors in a BST? Two things:
     *      if a node is in the ancestor's left subtree, then it must be less than the ancestor, and
     *      if a node is in the ancestor's right subtree, then it must be greater than the ancestor.
     *
     * We do a depth-first walk through the tree, testing each node for validity as we go. If a node appears in the left subtree of an ancestor,
     * it must be less than that ancestor. If a node appears in the right subtree of an ancestor, it must be greater than that ancestor.
     * Instead of keeping track of every ancestor to check these inequalities, we just check the largest number it must be
     * greater than (its lowerBound) and the smallest number it must be less than (its upperBound).
     */
    public static boolean isBinarySearchTree(BinaryTreeNode root) {

        // start at the root, with an arbitrarily low lower bound and an arbitrarily high upper bound
        Deque<NodeBounds> nodeAndBoundsStack = new ArrayDeque<>();
        nodeAndBoundsStack.push(new NodeBounds(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        // depth-first traversal
        while (!nodeAndBoundsStack.isEmpty()) {
            NodeBounds nb = nodeAndBoundsStack.pop();
            BinaryTreeNode node = nb.node;
            int lowerBound = nb.lowerBound;
            int upperBound = nb.upperBound;

            // if this node is invalid, we return false right away
            if (node.value < lowerBound || node.value >= upperBound) {
                return false;
            }

            if (node.left != null) {
                // this node must be less than the current node
                nodeAndBoundsStack.push(new NodeBounds(node.left, lowerBound, node.value));
            }
            if (node.right != null) {
                // this node must be greater than the current node
                nodeAndBoundsStack.push(new NodeBounds(node.right, node.value, upperBound));
            }
        }

        // if none of the nodes were invalid, return true (at this point we have checked all nodes)
        return true;
    }

    private static class NodeBounds {

        BinaryTreeNode node;
        int lowerBound;
        int upperBound;

        NodeBounds(BinaryTreeNode node, int lowerBound, int upperBound) {
            this.node = node;
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }
    }


    /**
     *
     * We start with a method for getting the largest value. The largest value is simply the "rightmost" one, so we can get it in one walk down the tree by traversing
     * rightward until we don't have a right child anymore.
     *
     * With this in mind, we can also find the second largest in one walk down the tree. At each step, we have a few cases:
     *      If we have a left subtree but not a right subtree, then the current node is the largest overall (the "rightmost") node.
     *          The second largest element must be the largest element in the left subtree.
     *          We use our findLargest() method above to find the largest in that left subtree!
     *      If we have a right child, but that right child node doesn't have any children, then the right child must be the largest element and our current node
     *          must be the second largest element!
     *      Else, we have a right subtree with more than one element, so the largest and second largest are somewhere in that subtree. So we step right.
     */
    public static int findSecondLargest(BinaryTreeNode rootNode) {
        if (rootNode == null || (rootNode.left == null
                && rootNode.right == null)) {
            throw new IllegalArgumentException("Tree must have at least 2 nodes");
        }

        BinaryTreeNode current = rootNode;

        while (true) {

            // case: current is largest and has a left subtree
            // 2nd largest is the largest in that subtree
            if (current.left != null && current.right == null) {
                return findLargest(current.left);
            }

            // case: current is parent of largest, and largest has no children,
            // so current is 2nd largest
            if (current.right != null &&
                    current.right.left == null &&
                    current.right.right == null) {
                return current.value;
            }

            current = current.right;
        }
    }

    private static int findLargest(BinaryTreeNode rootNode) {
        BinaryTreeNode current = rootNode;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }

}

/**
 * A binary tree is a tree where every node has two or fewer children. The children are usually called left and right.
 *
 * The simplest ways to traverse the tree are depth-first and breadth-first.
 * They have the same time cost (they each visit each node once).
 * Depth-first traversal of a tree uses memory proportional to the depth of the tree,
 * while breadth-first traversal uses memory proportional to the breadth of the tree (how many nodes there are on the "level" that has the most nodes).
 *
 */
class BinaryTreeNode {

    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public ds.binarytree.BinaryTreeNode insertLeft(int leftValue) {
        this.left = new BinaryTreeNode(leftValue);
        return this.left;
    }

    public ds.binarytree.BinaryTreeNode insertRight(int rightValue) {
        this.right = new BinaryTreeNode(rightValue);
        return this.right;
    }
}
