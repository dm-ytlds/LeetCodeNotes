package com.demi.code;

import com.demi.code.utils.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 */
public class Q_111 {
    public int minDepth(TreeNode root) {
        // 终止条件：当前节点为null
        if (root == null) return 0;
        int leftH = minDepth(root.left);
        int rightH = minDepth(root.right);
        // 如果左子树为null，右子树不为null
        if (root.left == null && root.right != null) {
            return 1 + rightH;
        }
        // 如果左子树不为null，右子树为null
        if (root.left != null && root.right == null) {
            return 1 + leftH;
        }
        // 左右子树都不为null的情况
        return 1 + Math.min(leftH, rightH);
    }
}
