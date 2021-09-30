package com.demi.code;

import com.demi.code.utils.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 题目：不同的二叉搜索树 2
 *  二叉搜索树关键的性质是根节点的值大于左子树所有节点的值，小于右子树所有节点的值，且左子树和右子树也同样为二叉搜索树。
 *  因此在生成所有可行的二叉搜索树的时候，假设当前序列长度为 nn，如果我们枚举根节点的值为 i，
 *  那么根据二叉搜索树的性质我们可以知道左子树的节点值的集合为 [1…i−1]，右子树的节点值的集合为 [i+1…n]。
 *  而左子树和右子树的生成相较于原问题是一个序列长度缩小的子问题，因此我们可以想到用回溯的方法来解决这道题目。
 * 我们定义 generateTrees(start, end) 函数表示当前值的集合为 [start,end]，
 * 返回序列 [start,end] 生成的所有可行的二叉搜索树。按照上文的思路，
 * 我们考虑枚举 [start,end] 中的值 ii 为当前二叉搜索树的根，
 * 那么序列划分为了 [start,i−1] 和 [i+1,end] 两部分。
 * 我们递归调用这两部分，即 generateTrees(start, i - 1) 和 generateTrees(i + 1, end)，
 * 获得所有可行的左子树和可行的右子树，那么最后一步我们只要从可行左子树集合中选一棵，再从可行右子树集合中选一棵拼接到根节点上，
 * 并将生成的二叉搜索树放入答案数组即可。
 * 递归的入口即为 generateTrees(1, n)，出口为当 start>end 的时候，当前二叉搜索树为空，返回空节点即可。
 *
 */
public class Q_95 {
    public static void main(String[] args) {
        List<TreeNode> res = generateTrees(3);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>();
        if (n == 0) {
            return list;
        }
        return process(1, n);
    }

    private static List<TreeNode> process(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        // 没有数字的情况
        if (start > end) {
            res.add(null);
            return res;
        }
        // 如果只有一个数字
        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }

        // 尝试每个数字作为根节点
        for (int i = start; i <= end; i++) {
            // 得到所有可能的左子树
            List<TreeNode> leftTrees = process(start, i - 1);
            // 得到所有可能的右子树
            List<TreeNode> rightTrees = process(i + 1, end);

            // 左右子树两两结合
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    // 加入最终结果
                    res.add(root);
                }
            }
        }
        return res;
    }
}
