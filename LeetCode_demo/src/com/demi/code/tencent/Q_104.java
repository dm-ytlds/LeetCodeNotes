package com.demi.code.tencent;

import com.demi.code.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 题目：二叉树的最大深度
 */
public class Q_104 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        System.out.println(maxDepth02(n1));
    }

    /**
     * 深度优先遍历
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftH = maxDepth(root.left);
            int rightH = maxDepth(root.right);
            return Math.max(leftH, rightH) + 1;
        }
    }

    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    public static int maxDepth02(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                size--;
            }
            res++;
        }
        return res;
    }
}
