package tree.binarytree.solution;

import tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/10/27 12:53
 */

public class Q101_IS_Symmtric {
    /**
     * 第一种方式
     */
    List<Integer> list = new ArrayList<Integer>();
    List<Integer> symList = new ArrayList<Integer>();
    private boolean isSymmetric01(TreeNode root){
        if(root == null){
            return true;
        }
        preOrder(root);
        symPreOrder(root);
        if(list.size() != symList.size()){
            return false;
        }
        for(int i = 0; i < list.size(); i++){
            if(!list.get(i).equals(symList.get(i))){
                return false;
            }
        }
        return true;
    }
    private void preOrder(TreeNode root){
        if(root == null){
            list.add(Integer.MIN_VALUE);
            return;
        }
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    private void symPreOrder(TreeNode root){
        if(root == null){
            symList.add(Integer.MIN_VALUE);
            return;
        }
        symList.add(root.val);
        symPreOrder(root.right);
        symPreOrder(root.left);
    }

    /**
     * 第二种方式：递归
     * @param root 根节点
     * @return 是否为对称二叉树
     */
    private boolean isSymmetric(TreeNode root){
        return isSymmetric(root, root);

    }
    private boolean isSymmetric(TreeNode root1, TreeNode root2){
        //1.两个都为空
        if(root1 == null && root2 == null){
            return true;
        }
        //2.必有一个为空
        if(root1 == null || root2 ==null){
            return false;
        }
        //3.两个都不为空，且值不相等
        if(root1.val != root2.val){
            return false;
        }
        //4.两值相等情况
        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }


    /**
     * 第三种方式：迭代
     */
    LinkedList<TreeNode> que = new LinkedList<TreeNode>();
    private boolean isSymmetric03(TreeNode root){
        return isSymmetric(root, root);
    }
    private boolean isSymmetric03(TreeNode root1, TreeNode root2){
        //1.初始化添加节点
        que.add(root1);
        que.add(root2);
        while(!que.isEmpty()){
            //2.获取节点
            TreeNode cur1 = que.pollFirst();
            TreeNode cur2 = que.pollFirst();

            //3.针对各种情况做不同的处理
            if(cur1 == null && cur2 == null){
                continue;
            }
            if(cur1 == null || cur2 == null){
                return false;
            }
            if(cur1.val != cur2.val){
                return false;
            }
            //4.当前节点值相等则继续进行下一个步骤
            que.add(cur1.left);
            que.add(cur2.right);
            que.add(cur1.right);
            que.add(cur2.left);
        }
        return true;
    }





    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(3);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        Q101_IS_Symmtric m = new Q101_IS_Symmtric();
        boolean flag = m.isSymmetric(n1);
        System.out.println(flag);
    }

}
