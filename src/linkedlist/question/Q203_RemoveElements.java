package linkedlist.question;

import linkedlist.ListNode;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/19 23:30
 */

public class Q203_RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        //1.使用哑节点
        ListNode nullNode = new ListNode(0);
        nullNode.next = head;
        ListNode cur = head;
        ListNode last = nullNode;
        while(cur != null){
            if(cur.val == val){
                ListNode temp = cur;
                last.next = last.next.next;
                cur = temp.next;
            }else{
                last = cur;
                cur = cur.next;
            }
        }
        return nullNode.next;
    }
}
