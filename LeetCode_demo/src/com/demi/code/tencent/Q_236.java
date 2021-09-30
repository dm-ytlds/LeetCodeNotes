package com.demi.code.tencent;

import com.demi.code.utils.TreeNode;

/**
 * 题目：二叉树的最近公共祖先
 *
 */
public class Q_236 {
    public static void main(String[] args) {

    }

    /*private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestorProcess(root, p, q);
    }

    private static TreeNode lowestCommonAncestorProcess(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestorProcess(root.left, p, q);
        TreeNode right = lowestCommonAncestorProcess(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        }
        return left;
    }*/


    // 简化版

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else {
            return null;
        }
    }
}
