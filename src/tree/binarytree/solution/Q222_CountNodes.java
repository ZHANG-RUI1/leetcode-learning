package tree.binarytree.solution;

import tree.binarytree.TreeNode;

import java.util.LinkedList;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/24 22:34
 */

public class Q222_CountNodes {
    /**
     * 使用深度优先遍历
     * @param root 根节点
     * @return 总节点数
     */
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return left + 1 + right;
    }
    /**
     * 使用前序遍历的方式
     * @param root 根节点
     * @return 节点数
     */
    public int countNodes01(TreeNode root) {
        int i = 0;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while(root != null || !stack.isEmpty()){
            //前序遍历
            while(root != null){
                i++;
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            root = cur.right;
        }
        return i;
    }
}
