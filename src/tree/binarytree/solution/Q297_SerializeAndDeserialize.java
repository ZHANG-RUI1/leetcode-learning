package tree.binarytree.solution;

import tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/12 10:00
 */

public class Q297_SerializeAndDeserialize {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //1.如图所示采用层序遍历的方式序列化二叉树
        //2.即通过队列实现
        List<Integer> res =new ArrayList<Integer>();
        LinkedList<TreeNode> que =  new LinkedList<TreeNode>();
        que.add(root);
        while(!que.isEmpty()){
            //3.更新遍历当前节点
            TreeNode cur = que.pollFirst();
            if(cur == null){
                res.add(null);
            }else{
                res.add(cur.val);
            }

            //4.向队列中添加左右子节点
            if(cur != null){
                que.add(cur.left);
                que.add(cur.right);
            }

        }
        return res.toString();

    }

    // Decodes your encoded data to tree.
    //使用两个队列即可完成
    public TreeNode deserialize(String data) {
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        LinkedList<TreeNode> listHelp = new LinkedList<TreeNode>();
        String[] strs = data.substring(1, data.length() - 1).split(", ");
        for (String i : strs) {
            if("null".equals(i)){
                list.add(null);
            }else{
                TreeNode temp = new TreeNode(Integer.parseInt(i));
                list.add(temp);
            }
        }
        //1.创建根节点
        TreeNode cur = list.pollFirst();
        TreeNode root = cur;
        while(!list.isEmpty()){
            if(cur != null){
                TreeNode left = list.pollFirst();
                listHelp.add(left);
                cur.left = left;
                TreeNode right = list.pollFirst();
                listHelp.add(right);
                cur.right = right;
            }
            cur = listHelp.pollFirst();
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        Q297_SerializeAndDeserialize m = new Q297_SerializeAndDeserialize();
        String flag = m.serialize(n1);
        m.deserialize(flag);
        System.out.println(flag);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

