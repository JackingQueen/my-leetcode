package org.jtznenic.solution;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 求和表头
        ListNode sumHead = new ListNode();
        ListNode sumNode = sumHead;

        int l1Val = 0;
        int l2Val = 0;
        int sumVal = 0;
        // 进位
        int carry = 0;

        while (l1 != null || l2 != null) {

            if (l1 != null) {
                l1Val = l1.val;
                l1 = l1.next;
            } else {
                l1Val = 0;
            }

            if (l2 != null) {
                l2Val = l2.val;
                l2 = l2.next;
            } else {
                l2Val = 0;
            }

            sumVal = (l1Val + l2Val + carry) % 10;
            carry = (l1Val + l2Val + carry) / 10;

            sumNode.next = new ListNode(sumVal);
            sumNode = sumNode.next;
        }

        if (carry == 1) {
            sumNode.next = new ListNode(carry);
        }

        return sumHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
