package org.jtznenic.solution;

import java.util.LinkedList;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author JinTianzhen
 */
public class SubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // todo: 本题未解答

        int max = 0;
        LinkedList<Character> noRepeatCharList = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (noRepeatCharList.contains(ch)) {
                max = max < noRepeatCharList.size() ? noRepeatCharList.size() : max;

                while(!noRepeatCharList.peek().equals(ch)) {
                    noRepeatCharList.removeFirst();
                }
                noRepeatCharList.removeFirst();
            }
            noRepeatCharList.add(ch);
        }

        max = max < noRepeatCharList.size() ? noRepeatCharList.size() : max;

        return max;
    }
}
