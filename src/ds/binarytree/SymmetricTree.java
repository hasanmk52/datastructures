package ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hasankagalwala on 5/12/20
 * @project datastructures
 *
 * Given a binary tree, check whether it is a mirror of itself.
 *
 * For example, this binary tree is symmetric:
 *
 *      1
 *    /   \
 *   2     2
 *  / \   / \
 * 3   4 4   3
 *
 * But the following is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * The problem can be solved easily using recursion. Two binary trees T1 and T2 are symmetric if
 *  1.) the value of T1’s root node is same as the value of T2’s root node,
 *  2.) T1’s left subtree is symmetric with T2’s right subtree,
 *  3.) T1’s right subtree is symmetric with T2’s left subtree.
 *
 */
public class SymmetricTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(3);

        System.out.println(isSymmetric(node));
    }
    private static boolean isSymmetric(TreeNode node) {
        if(node == null) {
            return true;
        }
        return isSymmetric(node.left, node.right);
    }
    
    private static boolean isSymmetric(TreeNode a, TreeNode b) {
        if(a == null && b == null) {
            return true;
        }
        if(a == null || b == null) {
            return false;
        }

        return a.val == b.val &&
                isSymmetric(a.left, b.right) &&
                isSymmetric(a.right, b.left);
    }

}
