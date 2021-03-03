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

    // 官方解题，要比我的代码更清晰，但是原理是一样的
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;

            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            carry = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
