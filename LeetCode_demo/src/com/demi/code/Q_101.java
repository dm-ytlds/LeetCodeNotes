package com.demi.code;

import com.demi.code.utils.TreeNode;

/**
 * 对称二叉树
 *
 */
public class Q_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right);
    }

    /**
     * 使用后序遍历的递归方法实现
     * @param left 左子树
     * @param right 右子树
     * @return 是否是对称二叉树
     */
    private boolean compare(TreeNode left, TreeNode right) {
        // 情况1：左右子树都为null，则左右子树是对称的
        if (left == null && right == null) {
            return true;
        } else if (left == null && right != null) {
            // 情况2；左子树为null，右子树不为null，则左右子树不是对称的
            return false;
        } else if (left != null && right == null) {
            // 情况3；左子树不为null，右子树为null，则左右子树不是对称的
            return false;
        } else if (left.val != right.val) {
            // 情况4：左右子树都不为空，但值不等，则左右子树不对称
            return false;
        }
        // 比较左右子树的外侧节点，即左子树的左孩子和右子树的右孩子作比较
        boolean outside = compare(left.left, right.right);
        // 比较左右子树的内侧节点，即左子树的右孩子和右子树的左孩子
        boolean inside = compare(left.right, right.left);
        // 只有当左右子树的内外侧节点对应相等，才会是对称的
        return outside && inside;
    }
}
