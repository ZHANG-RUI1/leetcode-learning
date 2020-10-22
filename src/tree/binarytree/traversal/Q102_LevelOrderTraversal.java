package tree.binarytree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/10/22 17:30
 */

public class Q102_LevelOrderTraversal {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();
    LinkedList<TreeNode> que = new LinkedList<TreeNode>();
    /**主要思路：
    1.遍历当前节点时，使用队列依次添加当前杰迪纳的左子节点和右子节点
    2.更新根节点为从队列头取出的节点，重复*/
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return res;
        }
        //1.定义分层使用的变量：当前层还需打印的节点个数；下一层需要打印的节点个数
        int toBePrinted = 1;
        int nextLevel = 0;
        while(root != null || !que.isEmpty()){
            if(root != null){
                if(root.left != null){
                    que.add(root.left);
                    nextLevel++;
                }
                if(root.right != null){
                    que.add(root.right);
                    nextLevel++;
                }
            }
            list.add(root.val);
            toBePrinted--;
            //2.分层处理
            if(toBePrinted == 0 && !list.isEmpty()){
                res.add(new ArrayList<Integer>(list));
                list.clear();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }

            root = que.pollFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        Q102_LevelOrderTraversal m = new Q102_LevelOrderTraversal();
        m.levelOrder(n1);

    }
}
