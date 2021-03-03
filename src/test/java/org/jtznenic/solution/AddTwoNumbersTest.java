package org.jtznenic.solution;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class AddTwoNumbersTest {

    @Test
    public void test1() {
        ListNode l1 = this.buildListNode(2, 4, 3);
        ListNode l2 = this.buildListNode(5, 6, 4);
        ListNode expected = this.buildListNode(7, 0, 8);

        this.testAddTwoNumbers(l1, l2, expected);
        this.testAddTwoNumbers2(l1, l2, expected);
    }

    @Test
    public void test2() {
        ListNode l1 = this.buildListNode(0);
        ListNode l2 = this.buildListNode(0);
        ListNode expected = this.buildListNode(0);

        this.testAddTwoNumbers(l1, l2, expected);
        this.testAddTwoNumbers2(l1, l2, expected);
    }

    @Test
    public void test3() {
        ListNode l1 = this.buildListNode(9,9,9,9,9,9,9);
        ListNode l2 = this.buildListNode(9,9,9,9);
        ListNode expected = this.buildListNode(8,9,9,9,0,0,0,1);

        this.testAddTwoNumbers(l1, l2, expected);
        this.testAddTwoNumbers2(l1, l2, expected);
    }

    public void testAddTwoNumbers(ListNode l1, ListNode l2, ListNode expected) {
        ListNode result = new AddTwoNumbers().addTwoNumbers(l1, l2);
        Integer[] actual = this.toValList(result);
        Integer[] expectedList = this.toValList(expected);

        assertThat(actual, equalTo(expectedList));
    }

    public void testAddTwoNumbers2(ListNode l1, ListNode l2, ListNode expected) {
        ListNode result = new AddTwoNumbers().addTwoNumbers2(l1, l2);
        Integer[] actual = this.toValList(result);
        Integer[] expectedList = this.toValList(expected);

        assertThat(actual, equalTo(expectedList));
    }

    private ListNode buildListNode(int ... nums) {
        ListNode head = new ListNode();
        ListNode node = head;
        for (int i : nums) {
            node.next = new ListNode();
            node = node.next;
            node.val = i;
        }

        return head.next;
    }

    private Integer[] toValList(ListNode node) {
        List<Integer> list = Lists.newArrayList();

        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        return list.toArray(new Integer[0]);
    }
}
