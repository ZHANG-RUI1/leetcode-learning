package linkedlist.question;

import linkedlist.ListNode;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/19 10:05
 */

public class Q141_HasCycle {
    /**
     * 题目：
     *      给定一个链表，判断链表中是否有环。
     * @param head 输入头结点
     * @return 返回结果
     */
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slowIndex = head;
        ListNode quickIndex = head.next;
        boolean flag = false;
        //1.在链表中循环快慢指针
        while( slowIndex.next != null  && quickIndex != null && quickIndex.next != null){
            if(quickIndex.val == slowIndex.val){
                flag = true;
                break;
            }
            slowIndex = slowIndex.next;
            quickIndex = quickIndex.next.next;
        }

        return flag;
    }

    public static void main(String[] args) {
        Q141_HasCycle m = new Q141_HasCycle();
        ListNode n1 = new ListNode(1);
        boolean flag = m.hasCycle(n1);
    }
}
