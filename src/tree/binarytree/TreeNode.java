package tree.binarytree;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/10/21 22:43
 */

public class TreeNode {
    /**
     * 同一父包下，默认修饰符失效
     */
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
