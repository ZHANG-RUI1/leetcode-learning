package tree.binarytree.solution;

import tree.binarytree.Node;

import java.util.LinkedList;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/4 10:39
 */

public class Q116_Connect {
    LinkedList<Node> que = new LinkedList<Node> ();
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Node res = root;
        int toBeVisit = 1;
        int curLevelTotal = 1;
        int nextLevel = 0;
        Node cur = null;
        while(root != null || !que.isEmpty()){
            //1.将其左右子节点存入队列中
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
            //2.当前节点为某行的开始节点
            if(toBeVisit == curLevelTotal){
                cur = root;
            }else{
                if(cur != null){
                    cur.next = root;
                    cur = cur.next;
                }
            }
            toBeVisit--;
            if(toBeVisit <= 0){
                toBeVisit = nextLevel;
                curLevelTotal = nextLevel;
                nextLevel = 0;
                cur = null;
            }

            root = que.pollFirst();
        }
        return res;
    }


    public Node connect01(Node root){
        if(root == null){
            return null;
        }
        //1.从根节点开始
        Node leftmost = root;

        while(leftmost.left != null){
            //2.遍历当前层组织成的链表，为下一层的节点更新next指针
            Node head = leftmost;

            while(head != null){
                //3.条件1,同一个父节点
                head.left.next = head.right;

                //4.不同父节点
                if(head.next != null){
                    head.right.next = head.next.left;
                }
                //5.向后移动指针；
                head = head.next;
            }
            //进入下一层
            leftmost = leftmost.left;
        }
        return root;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        Q116_Connect ma = new Q116_Connect();
        ma.connect(n1);


    }

}
