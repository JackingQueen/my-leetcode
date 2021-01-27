package org.jtznenic.solution;

import java.util.Objects;

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

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    @Override
    public boolean equals(Object obj) {
        boolean flag = false;
        if (obj == null) {
            flag = false;
        }

        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListNode)) {
            return false;
        }
        ListNode other = (ListNode) obj;

        if (this.next == null && other.next == null) {
            flag = true;
        }

        if (other.next != null && this.next == null) {
            flag = false;
        }
        return this.val == other.val
            && flag
            && this.next != null ? this.next.equals(other.next) : true;
    }
}
