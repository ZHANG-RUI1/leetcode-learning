package linkedlist.question;

import linkedlist.Node;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/24 23:35
 */

public class Q430_Flatten {
    public Node flatten(Node head) {
        if (head == null) { return head; }

        Node pseudoHead = new Node(0, null, head, null);

        flattenDFS(pseudoHead, head);

        // detach the pseudo head from the real head
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }

    public Node flattenDFS(Node prev, Node curr) {
        if (curr == null) { return prev; }
        curr.prev = prev;
        prev.next = curr;

        Node tempNext = curr.next;

        Node tail = flattenDFS(curr, curr.child);
        curr.child = null;

        return flattenDFS(tail, tempNext);
    }


    public Node flatten01(Node head) {
        if(head == null){ return null; }
        Node cur = head;
        while(cur != null){
            if(cur.child != null){ DFS(cur); }
            cur = cur.next;
        }
        return head;
    }
    public void DFS(Node node){
        //1.备份有子链表的节点
        Node temp = null;
        if(node.next != null){
            temp = new Node();
            temp.next = node.next;
            node.next.prev = temp;
        }
        //2.将子节点转换为下一个节点
        node.next = node.child;
        node.child = null;
        node.next.prev = node;

        while(node.next != null){
            if(node.child != null){ DFS(node); }
            node = node.next;
        }
        //3.将剩余链表接上
        if(temp != null){
            node.next = temp.next;
            temp.next.prev = node;
        }
    }
}
