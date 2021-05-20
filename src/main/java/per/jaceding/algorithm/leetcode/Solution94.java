package per.jaceding.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历
 *
 * @author jaceding
 * @date 2020/9/29
 */
public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left != null) {
                inorderTraversal(root.left, list);
            }
            list.add(root.val);
            if (root.right != null) {
                inorderTraversal(root.right, list);
            }
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int minCount(int[] coins) {
        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            count += Math.ceil(coins[i] / 2d);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Math.ceil(3 / 2d));
    }
}
