package tree.binarytree.solution;

import tree.binarytree.TreeNode;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/10/27 23:14
 */

public class Q112_HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        //1.先进行前序遍历
        if(root == null){
            return false;
        }
        sum -= root.val;
        //2.只在这种情况下，条件成立
        if(sum == 0 && root.right == null && root.left == null){
            return true;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
