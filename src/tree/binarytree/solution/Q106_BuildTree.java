package tree.binarytree.solution;

import tree.binarytree.TreeNode;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/2 23:03
 */

public class Q106_BuildTree {

    /**
     * 递归解决
     * @param inorder 中序遍历序列
     * @param postorder 后续遍历序列
     * @return 返回树
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0){
            return null;
        }
        return rebuild(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    private TreeNode rebuild(int[] inorder,int[] postorder, int inL, int inR, int postL, int postR){
        if(inR < inL || postR < postL ){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postR]);

        int index = -1;
        for(int i = inL; i <= inR; i++){
            if(inorder[i] == postorder[postR]){
                index = i;
                break;
            }
        }
        //创建左子树
        root.left = rebuild(inorder, postorder, inL, index - 1, postL,index - inL + postL - 1);
        //创建右子树L
        root.right = rebuild(inorder, postorder, index + 1, inR, index - inL + postL, postR - 1);
        return root;
    }
}
