package com.demi.code;

import com.demi.code.utils.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 翻转二叉树
 */
public class Q_226 {
    /**
     * 前序遍历的递归方式实现
     * @param root 根节点
     * @return 翻转后的根节点
     */
    public TreeNode invertTree(TreeNode root) {
        // 终止条件：当前遍历到的节点为null
        if (root == null) return null;
        // 交换位置
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 左子树上的节点也翻转
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 前序遍历的迭代方式实现
     * @param root 根节点
     * @return 翻转后的根节点
     */
    public TreeNode invertTree_iter(TreeNode root) {
        if (root == null) return null;
        // 用栈存储节点。当然也可以用链表
        // LinkedList<TreeNode> list = new LinkedList<>(); 用list的add(node)和pop()方法实现节点的添加和节点的弹出
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            // 当前节点
            TreeNode curr = stack.pop();
            // 交换位置
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            // 左右子树上的节点也翻转
            // 因为使用的栈，所以先右后左
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
        return root;
    }
}
