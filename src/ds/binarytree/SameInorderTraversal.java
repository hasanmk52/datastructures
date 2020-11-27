package ds.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hasankagalwala on 5/13/20
 * @project datastructures
 *
 * Given two binary trees, determine whether they have the same inorder traversal
 *
 * Tree 1:                      Tree 2:
 *
 *      5                            3
 *     /  \                        /   \
 *    3    7                     1      6
 *   /     /                           /  \
 *  1     6                           5    7
 *
 *  [1,3,5,6,7]                  [1,3,5,6,7]
 */
public class SameInorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(5);
        tree1.left = new TreeNode(3);
        tree1.left.left = new TreeNode(1);
        tree1.right = new TreeNode(7);
        tree1.right.left = new TreeNode(6);

        TreeNode tree2 = new TreeNode(3);
        tree2.left = new TreeNode(1);
        tree2.right = new TreeNode(6);
        tree2.right.left = new TreeNode(5);
        tree2.right.right = new TreeNode(7);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorder(tree1,list1);
        inorder(tree2,list2);

        System.out.println(list1.equals(list2));
    }

    private static void inorder(TreeNode root, List<Integer> list) {

        if(root == null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}
