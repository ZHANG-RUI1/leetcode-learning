package linkedlist;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/24 23:39
 */

public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int val,Node prev,Node next,Node child) {
        val = val;
        prev = prev;
        next = next;
        child = child;
    }
}

