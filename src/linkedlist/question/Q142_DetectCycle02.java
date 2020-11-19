package linkedlist.question;

import linkedlist.ListNode;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2020/11/19 10:45
 */

public class Q142_DetectCycle02 {
    /**
     * 题目：
     *        给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。（包含重复数）
     *  a：环之外的长度，
     *  b：快慢指针在环中入口到相遇的地方的距离
     *  c：相遇地方到入口的距离
     *  dq = a + n*(b+c) + b
     *  ds = a + b
     *  dq =2*ds
     *  a = (n - 1)(b + c) + c
     * @param head 链表头节点
     * @return 返回结果
     */
    public ListNode detectCycle02(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head, quick = head;
        ListNode res = null;
        while(quick != null){
            slow = slow.next;
            if(quick.next != null){
                quick = quick.next.next;
            }else{
                break;
            }
            //C
            if(slow.equals(quick)){
                res = head;
                while(!res.equals(slow)){
                    res = res.next;
                    slow = slow.next;
                }
                break;
            }
        }
        return res;
    }

    public ListNode detectCycle01(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode res = null;
        ListNode slowIndex = head;
        ListNode quickIndex = head.next;
        ListNode cirIndex = null;
        int n = 0;

        //1.判断链表是否包含环，并记录环中的某个节点
        while(slowIndex.next != null && quickIndex != null && quickIndex.next != null){
            if(slowIndex.equals(quickIndex)){
                cirIndex = slowIndex;
                break;
            }
            slowIndex = slowIndex.next;
            quickIndex = quickIndex.next.next;
        }

        //2.统计环中的节点数
        while(cirIndex != null){
            n++;
            if(cirIndex.next.equals(slowIndex)){
                break;
            }
            cirIndex = cirIndex.next;
        }
        //快慢指针归位
        slowIndex = head;
        quickIndex = head;

        //3.根据环中的节点数，将快指针向后挪n位，并与慢指针同步长遍历链表，找到入口
        while(n > 0){
            while(n > 0){
                quickIndex = quickIndex.next;
                n--;
            }
            while(!quickIndex.equals(slowIndex)){
                quickIndex = quickIndex.next;
                slowIndex = slowIndex.next;
            }
            res = slowIndex;
        }
        return res;
    }



    public static void main(String[] args) {


        ListNode n1 = new ListNode(-1);
        ListNode n2 = new ListNode(-7);
        ListNode n3 = new ListNode(7);
        ListNode n4 = new ListNode(-4);
        ListNode n5 = new ListNode(19);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(-9);
        ListNode n8 = new ListNode(-5);
        ListNode n9 = new ListNode(-2);
        ListNode n10 = new ListNode(-5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = n7;
        Q142_DetectCycle02 m = new Q142_DetectCycle02();
    }
}
