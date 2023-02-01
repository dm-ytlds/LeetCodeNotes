package com.demi.code;

import com.demi.code.utils.TreeNode;

/**
 * 二叉树的最大深度
 */
public class Q_104 {
    /**
     * 注意：递归包含每一层都有一个比较出当前节点的左右子树的较大值的过程，并返回给上一层递归
     * @param root 当前节点
     * @return 当前节点的最大深度（高度）
     */
    public int maxDepth(TreeNode root) {
        // 终止条件：当前节点为null
        if (root == null) return 0;
        // 左子树的高度
        int leftH = maxDepth(root.left);
        // 右子树的高度
        int rightH = maxDepth(root.right);
        // 最终返回左右子树中较大值加1的结果
        return Math.max(leftH, rightH) + 1;
    }
}
