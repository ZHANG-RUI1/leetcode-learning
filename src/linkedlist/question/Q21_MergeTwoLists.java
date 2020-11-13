package linkedlist.question;

import linkedlist.ListNode;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/13 23:06
 */

public class Q21_MergeTwoLists {
    /**
     * 题目：
     *      将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * @param l1 待排序链表1
     * @param l2 待排序链表2
     * @return 返回结果
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //1.定义一个盲节点，用于初始化新的链表
        ListNode head = new ListNode();
        ListNode newHead = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                head.next = l1;
                l1 = l1.next;
            }else{
                head.next =l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        while(l1  != null){
            head.next = l1;
            l1 = l1.next;
            head = head.next;
        }
        while(l2  != null){
            head.next = l2;
            l2 = l2.next;
            head = head.next;
        }
        return newHead.next;
    }
}
