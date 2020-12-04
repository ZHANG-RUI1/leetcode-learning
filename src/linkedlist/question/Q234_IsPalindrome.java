package linkedlist.question;

import linkedlist.ListNode;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/24 10:38
 */

public class Q234_IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        boolean flag = true;
        //0.统计节点数
        ListNode cur = head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        //1.反转后半段链表
        int index = count/2;
        ListNode lastHead = null;
        cur = head;
        int i = 1;
        while(cur != null){
            if(i == index){
                lastHead = cur;
                break;
            }
            cur = cur.next;
            i++;
        }
        ListNode reverHead = reverse(lastHead);
        //2.比较
        cur = head;
        ListNode reverCur = reverHead;
        while(cur != null && reverCur != null){
            if(cur.val != reverCur.val){
                flag = false;
                break;
            }
            cur = cur.next;
            reverCur = reverCur.next;
        }
        //3.恢复后半段链表
        reverse(reverHead);
        return flag;
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next ==null){
            return head;
        }
        ListNode last = head;
        ListNode cur = head.next;
        ListNode pre = head.next.next;
        head.next = null;
        while(pre != null){
            cur.next = last;
            last = cur;
            cur = pre;
            pre = pre.next;
        }
        cur.next = last;
        return cur;
    }
}
