package org.jtznenic.solution;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
public class TwoSumTest {
    @Test
    public void test1() {
        this.testTwoSum(buildNums(2, 7, 11, 15), 9, buildexpecteds(0, 1));
        this.testTwoSum2(buildNums(2, 7, 11, 15), 9, buildexpecteds(0, 1));
    }

    @Test
    public void test2() {
        this.testTwoSum(buildNums(3, 2, 4), 6, buildexpecteds(1, 2));
        this.testTwoSum2(buildNums(3, 2, 4), 6, buildexpecteds(1, 2));
    }

    @Test
    public void test3() {
        this.testTwoSum(buildNums(3, 3), 6, buildexpecteds(0, 1));
        this.testTwoSum2(buildNums(3, 3), 6, buildexpecteds(0, 1));
    }


    public int[] buildNums(int ... nums) {
        return nums;
    }

    public int[] buildexpecteds(int ... expecteds) {
        return expecteds;
    }

    public void testTwoSum(int[] nums, int target, int[] expecteds) {
        assertThat(new TwoSum().twoSum(nums, target), equalTo(expecteds));
    }

    public void testTwoSum2(int[] nums, int target, int[] expecteds) {
        assertThat(new TwoSum().towSum2(nums, target), equalTo(expecteds));
    }
}
