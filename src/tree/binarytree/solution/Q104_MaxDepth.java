package tree.binarytree.solution;

import tree.binarytree.TreeNode;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/10/27 9:35
 */

public class Q104_MaxDepth {
    /**
     * 自下而上
     **/
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;

    }

    int res = 0;
    /**
     * 自上而下
     */
    public int maxDepth02(TreeNode root) {
        //初始调用
        return maxDepth(root, 0);
    }

    /**
     * 当前节点的深度
     */
    private int maxDepth(TreeNode root, int depth){
        if(root == null){
            return depth;
        }
        //root 不为空时，深度+1
        depth++;
        if(root.left == null && root.right == null){
            res = Math.max(res, depth);
        }
        maxDepth(root.left, depth);
        maxDepth(root.right, depth);
        return res;
    }

}
