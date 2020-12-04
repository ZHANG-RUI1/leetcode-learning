package linkedlist.question;

import linkedlist.ListNode;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/24 11:39
 */
public class Q2_AddTwoNumbers {

    public ListNode addTwoNumbers02(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int num = 0;
        //1.遍历两个链表
        while(cur1 != null && cur2 != null){
            int temp;
            temp = cur1.val + cur2.val + num;
            num = temp / 10;
            //更新新链表的当前节点
            addNode(newHead, temp % 10);
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        //2.
        while(cur1 != null){
            int temp;
            temp = cur1.val + num;
            num = temp / 10;
            //更新新链表的当前节点
            addNode(newHead, temp % 10);
            cur1 = cur1.next;
        }
        while(cur2 != null){
            int temp;
            temp = cur2.val + num;
            num = temp / 10;
            //更新新链表的当前节点
            addNode(newHead, temp % 10);
            cur2 = cur2.next;
        }
        //2.处理最后一位需要进位的情况
        if(num != 0){
            addNode(newHead, num);
        }

        return newHead.next;
    }

    public ListNode addTwoNumbers01(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int num = 0;
        //1.遍历两个链表
        while(cur1 != null || cur2 != null){
            int temp;
            if(cur2 == null){
                temp =cur1.val + num;
            }else if (cur1 == null){
                temp = cur2.val + num;
            }else{
                temp = cur1.val + cur2.val + num;
            }
            num = temp / 10;
            //更新新链表的当前节点
            addNode(newHead, temp % 10);
            if(cur1 != null){
                cur1 = cur1.next;
            }
            if(cur2 != null) {
                cur2 = cur2.next;
            }
        }
        //2.处理最后一位需要进位的情况
        if(num != 0){
            addNode(newHead, num);
        }

        return newHead.next;
    }
    private void addNode(ListNode newHead, int val){
        ListNode node = new ListNode(val);
        ListNode cur = newHead;
        while(cur.next != null){
            cur = cur.next;
        }
        //找到空节点并赋值
        cur.next = node;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n4.next = n5;
        n5.next = n6;
        Q2_AddTwoNumbers m = new Q2_AddTwoNumbers();
        m.addTwoNumbers01(n1, n4);
    }
}
