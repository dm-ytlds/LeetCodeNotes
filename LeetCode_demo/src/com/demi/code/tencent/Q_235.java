package com.demi.code.tencent;

import com.demi.code.utils.TreeNode;

/**
 * 题目：二叉搜索树的最近公共祖先
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class Q_235 {
    public static void main(String[] args) {

    }

    /**
     * 根据二叉搜索树的特性：根节点的左子树上的数字一定小于根节点的值，右子树上的数字一定大于根节点的数值。
     *  从根节点开始遍历，第一个父节点为根节点。
     *                 如果p.val和q.val均小于父节点，说明p, q都在左子树上；
     *                 如果p.val和q.val均大于父节点，说明p, q都在右子树上；
     *                 第三种情况就是以父节点为分叉点，说明p, q一个在左子树上，一个在右子树上，最近公共祖先可能是当前父节点，
     *                 或者其中一个节点就是当前的最近公共祖先。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode par = root;
        while (true) {
            if (p.val < par.val && q.val < par.val) {
                par = par.left;
            } else if (p.val > par.val && q.val > par.val) {
                par = par.right;
            } else {
                break;
            }
        }
        return par;
    }

}
