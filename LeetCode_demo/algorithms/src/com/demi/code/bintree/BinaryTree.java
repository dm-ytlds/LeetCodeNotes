package com.demi.code.bintree;

import javax.xml.transform.Templates;
import java.util.*;

/**
 * 二叉树的几种遍历方法实现
 */
public class BinaryTree {
    public static void main(String[] args) {
        // 创建节点
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        // 定义节点间的关系
        TreeNode root = node1;
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
//        // 验证先序遍历
//        preOrder(root);
//        preOrder_iter(root);
//        // 验证中序遍历
//        inOrder(root);
//        inOrder_stack(root);
        // 验证后序遍历
//        backOrder(root);
        backOrder_iter(root);
        for (int value : lists) {
            System.out.println(value);
        }
    }

    public static List<Integer> lists = new ArrayList<>();
    // 1.1 先序遍历 --> 递归实现
    public static void preOrder(TreeNode root) {
        if (root != null) {
            lists.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // 1.2 先序遍历 --> 迭代实现
    public static void preOrder_iter(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            lists.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    // 2.1 中序遍历--> 递归实现
    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            lists.add(root.val);
            inOrder(root.right);
        }
    }

    // 2.2 中序遍历--> 迭代实现
    public static void inOrder_stack(TreeNode root) {
        // 准备一个栈，存储遍历的根节点
        Deque<TreeNode> stack = new ArrayDeque<>();
        // 用while循环
        while (root != null || !stack.isEmpty()) {
            // 循环到最左边子节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            lists.add(root.val);
            root = root.right;
        }
    }

    // 后序遍历--> 递归实现
    public static void backOrder(TreeNode root) {
        if (root != null) {
            backOrder(root.left);
            backOrder(root.right);
            lists.add(root.val);
        }
    }

    // 后序遍历 --> 迭代实现
    // 整体和先序遍历的迭代实现方法一样
    public static void backOrder_iter(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            // 每次将节点的值放在列表的首位
            lists.add(0, temp.val);
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }
    }
}

// 定义节点类
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }

}