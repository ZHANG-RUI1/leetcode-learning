package linkedlist.question;

import linkedlist.ListNode;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/19 16:05
 */

public class Q160_GetIntersectionNode {

    /**
     * 题目：
     *        相交链表：编写一个程序，找到两个单链表相交的起始节点。
     * @param headA 链表1
     * @param headB 链表2
     * @return 返回相交节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m = getLinkedListLength(headA);
        int n = getLinkedListLength(headB);
        ListNode res = null;
        int dis = m - n;
        ListNode headLong = headA;
        ListNode headShort = headB;
        if(n > m){
            headLong = headB;
            headShort = headA;
            dis = n - m;
        }
        //长链表先走
        while(dis > 0){
            headLong = headLong.next;
            dis--;
        }
        while(headLong != null && headShort != null){
            if(headLong.equals(headShort)){
                res = headShort;
                break;
            }
            headLong = headLong.next;
            headShort = headShort.next;
        }
        return res;

    }
    public int getLinkedListLength(ListNode head){
        int n = 0;
        while(head != null){
            n++;
            head = head.next;
        }
        return n;
    }
}
