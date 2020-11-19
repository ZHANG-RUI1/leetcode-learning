package linkedlist.question;

import linkedlist.ListNode;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/19 17:21
 */

public class Q19_RemoveNthFromEnd {
    /**
     * 不改变链表
     * @param head 待删除列表
     * @param n 倒数
     * @return 删除后链表
     */
    public ListNode removeNthFromEnd02(ListNode head, int n){
        //1.哑节点
        ListNode nullNode = new ListNode(0);
        nullNode.next = head;
        ListNode fast = nullNode;
        ListNode slow = nullNode;
        ListNode last = null;
        int k = n - 1;
        //1.fast移动k次
        while(k > 0 && fast.next != null){
            fast = fast.next;
            k--;
        }
        //2.快指针移动到链表末尾节点
        while(fast.next != null){
            fast = fast.next;
            last = slow;
            slow = slow.next;
        }
        //3.删除节点
        if(last != null){
            last.next = last.next.next;
            slow.next = null;
        }
        return nullNode.next;
    }

    public ListNode removeNthFromEnd01(ListNode head, int n) {
        if(head == null){
            return null;
        }
        int k = n - 1;
        int i = k;
        ListNode slow = head;
        ListNode fast = head;
        ListNode lastNode = null;
        //1.移动指针快指针到同时出发处
        while(k > 0  && fast.next != null){
            fast = fast.next;
            k--;
        }
        //1.寻找链表的最后一个非空节点
        while(fast.next != null){
            fast = fast.next;
            lastNode = slow;
            slow = slow.next;
        }
        //两种情况的删除操作
        //1.删除的是从第二个开始的节点
        if(lastNode != null && slow != null){
            lastNode.next = lastNode.next.next;
            slow.next = null;
        }else if(lastNode == null && i + 1 == n){
            //2.删除头结点
            head = head.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode n1 =  new ListNode(1);
        Q19_RemoveNthFromEnd m = new Q19_RemoveNthFromEnd();
        m.removeNthFromEnd02(n1, 1);
    }
}

