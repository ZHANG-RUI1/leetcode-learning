package linkedlist.question;

import linkedlist.ListNode;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/19 22:57
 */

public class Q206_ReverseList {
    /**
     * 反转链表
     * @param head 待反转链表
     * @return 返回新链表的头节点
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode last = head;
        ListNode cur = head.next;
        ListNode pre = head.next.next;
        //1.置空头链表
        head.next = null;
        //2.拆分重组链表，一直到pre为null,即只剩尾节点待处理
        while(pre != null){
            cur.next = last;
            last = cur;
            cur = pre;
            pre = pre.next;
        }
        //3.处理尾节点
        cur.next = last;
        return cur;
    }
}
