package tree.binarytree.solution;


import tree.binarytree.TreeNode;

import java.util.LinkedList;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/10 11:43
 */

public class Q236_LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q){
            return root;
        }
        if(root != null){
            TreeNode lnode = lowestCommonAncestor(root.left, p, q);
            TreeNode rnode = lowestCommonAncestor(root.right, p, q);
            //1.表明左右子树各有一个节点
            if(lnode != null && rnode != null){
                return root;
            }else if(lnode == null){
                //2.表明两个节点均在右子树
                return rnode;
            }else{
                //3.两个节点均在左子树
                return lnode;
            }
        }
        return null;
    }



    /**
     * 寻找并存储已遍历节点
     */
    boolean isFund = false;

    public TreeNode lowestCommonAncestor01(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> list1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> list2 = new LinkedList<TreeNode>();
        //1.对两个节点分别进行前序遍历，并保存序列到list中
        preOrder(root, p.val, list1);
        //isFund 归位
        isFund = false;
        preOrder(root, q.val, list2);
        TreeNode ances = null;
        //2.遍历两个序列
        int i = 0;
        while(i < list1.size() && i < list2.size()){
            if(list1.get(i).val == list2.get(i).val){
                ances = list1.get(i);
            }else{
                break;
            }
            i++;
        }
        return ances;
    }

    public void preOrder(TreeNode root, Integer val, LinkedList<TreeNode> list){
        list.add(root);
        if(val == root.val){
            isFund = true;
            return;
        }
        //左遍历
        if(!isFund && root.left != null){
            preOrder(root.left, val, list);
        }
        //右遍历
        if(!isFund && root.right != null){
            preOrder(root.right, val, list);
        }
        if(!isFund){
            list.pollLast();
        }
    }
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(0);
        TreeNode n7 = new TreeNode(8);
        TreeNode n8 = new TreeNode(7);
        TreeNode n9 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.left = n8;
        n5.right = n9;

        Q236_LowestCommonAncestor ma = new Q236_LowestCommonAncestor();
        ma.lowestCommonAncestor(n1, n2, n9);


    }
}
