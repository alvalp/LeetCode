package org.alvin.leet.code;

public class Solution206 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {

        if(head == null || head.next== null){
            return head;
        }

        ListNode pre = head;
        ListNode next = head.next;
        pre.next = null;
        while(next != null){
            ListNode temp = next.next;
            next.next = pre;
            pre= next;
           next = temp;
        }
        return pre;
    }
}
