package tree.binarytree.solution;

import tree.binarytree.TreeNode;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/10/28 10:18
 */

public class Q105_BuildTree {
    /**
     * 递归解决
     * @param preorder 前序遍历序列
     * @param inorder 中序遍历序列
     * @return 树
     */
    private TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 && inorder.length ==0){
            return null;
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);

    }
    private TreeNode buildTree(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR){
        if(preR < preL || inR < inL){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preL]);
        int index = -1;
        //1.找到根节点
        for(int i = inL; i <= inR; i++){
            if(inorder[i] == preorder[preL]){
                index = i;
                break;
            }
        }

        //构建左子树
        //**一定注意左子树前序遍历的右索引书写方式：**
        //				（当前根节点在中序遍历中的索引 - 中序遍历左索引 + 前序遍历左索引）
        root.left = buildTree(preorder, inorder, preL+1, index - inL + preL, inL, index - 1);
        //构建右子树
        root.right = buildTree(preorder, inorder, index - inL + preL + 1, preR, index + 1, inR);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        Q105_BuildTree m = new Q105_BuildTree();
        m.buildTree(pre, in);
    }
}
