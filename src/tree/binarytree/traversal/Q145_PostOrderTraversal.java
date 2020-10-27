package tree.binarytree.traversal;

import tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/10/21 22:39
 */

public class Q145_PostOrderTraversal {
    List<Integer> list = new ArrayList<Integer>();
    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    public List<Integer> postorderTraversal(TreeNode root) {
        while(root != null || !stack.isEmpty()){
            //1.一直寻找当前根节点的最右子节点，并将沿途的节点压入栈中
            while(root != null){
                list.add(root.val);
                stack.push(root);
                root = root.right;
            }
            //2.更新根节点
            TreeNode cur = stack.pop();
            root = cur.left;
        }
        Collections.reverse(list);
        return list;
    }


}
