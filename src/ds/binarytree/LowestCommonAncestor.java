package ds.binarytree;

/**
 * @author hasankagalwala on 5/13/20
 * @project datastructures
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as
 * the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAncestor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //This solution is for a BST
    public TreeNode lowestCommonAncestorForBST(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }

    //This solution is for a BT
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode leftSearch = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSearch = lowestCommonAncestor(root.right, p, q);

        if (leftSearch == null) {
            return rightSearch;
        }
        if (rightSearch == null) {
            return leftSearch;
        }

        return root;
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        /*LowestCommonAncestor lca = new LowestCommonAncestor();
        lca.root = new Node(1);
        lca.root.left = new Node(2);
        lca.root.right = new Node(3);
        lca.root.left.left = new Node(4);
        lca.root.left.right = new Node(5);
        lca.root.right.left = new Node(6);
        lca.root.right.right = new Node(7);
        System.out.println("LCA(4, 5) = " +
                lca.findLCA(4, 5).data);
        System.out.println("LCA(4, 6) = " +
                lca.findLCA(4, 6).data);
        System.out.println("LCA(3, 4) = " +
                lca.findLCA(3, 4).data);
        System.out.println("LCA(2, 4) = " +
                lca.findLCA(2, 4).data);*/
    }

}
