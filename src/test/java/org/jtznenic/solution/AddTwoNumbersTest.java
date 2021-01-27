package org.jtznenic.solution;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AddTwoNumbersTest {

    private AddTwoNumbers obj;

    private ListNode input1;
    private ListNode input2;
    private ListNode expected;


   /**
     * @param input1
     * @param input2
     * @param expected
     */
    public AddTwoNumbersTest(ListNode input1, ListNode input2, ListNode expected) {
        this.input1 = input1;
        this.input2 = input2;
        this.expected = expected;
    }

    @Parameters
    public static Collection<List<ListNode>> prepareData() {
        int[][][] object = new int[][][] {
            {{2, 4, 4}, {5, 6, 4}, {7, 0, 8}},
            {{0}, {0}, {0}},
            {{9,9,9,9,9,9,9}, {9,9,9,9}, {8,9,9,9,0,0,0,1}}
        };

        List<List<ListNode>> list = new ArrayList<>();
        for (int[][] i : object) {
            List<ListNode> line = new ArrayList<>();
            for (int[] j : i) {
                ListNode head = new ListNode();
                ListNode l1 = head;
                for (int k : j) {
                    l1.next = new ListNode(k);
                    l1 = l1.next;
                }
                line.add(head.next);
            }
            list.add(line);
        }
        return list;
    }

    @Before
    public void setUp() {
        obj = new AddTwoNumbers();
    }

    @Test
    public void testAddTwoNumbers() {
        ListNode result = obj.addTwoNumbers(input1, input2);

        assertThat(result, equalTo(expected));
    }
}
