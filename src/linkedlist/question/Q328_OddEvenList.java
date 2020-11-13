package linkedlist.question;

import linkedlist.ListNode;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/13 22:37
 */

public class Q328_OddEvenList {
    /**
     * 题目：
     *      给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节
     *      点指的是节点编号的奇偶性，而不是节点的值的奇偶性。请尝试使用原地算法完成。你的算法的空
     *      间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
     *
     * 思路：
     *      1.使用两个头节点遍历并重新构建此列表为两个链表
     *          分别为 1，3，5 ……  2，4，6 ……
     *      2.然后将第一个链表的尾结点接到第二个链表的头结点
     *         head.next = head2.next;
     *         head2.next = head2.next.next;
     * @param head 输入链表头结点
     * @return 返回新的链表
     */
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode head2 = head.next;
        ListNode newHead = head;
        ListNode newHead2 = head2;
        while(head.next != null && head2.next != null){
            head.next = head2.next;
            head2.next = head2.next.next;
            head = head.next;
            head2 = head2.next;
        }
        head.next = newHead2;
        return newHead;
    }
}
