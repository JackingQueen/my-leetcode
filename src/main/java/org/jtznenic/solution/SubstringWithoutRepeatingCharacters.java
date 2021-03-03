package org.jtznenic.solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
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

    // 官方实现，和我的思路大致一致，但是要比我的简便很多
    // 使用「滑动窗口」来解决这个问题
    public int lengthOfLongestSubstring2(String s) {
        Set<Character> occ = new HashSet<>();
        int max = 0;
        int rk = -1;

        for (int i = 0; i < s.length(); i++) {
            // 删除上次左边界的值
           if (i != 0) {
                occ.remove(s.charAt(i-1));
           }

           // 记录最近的不重复值
           while (rk + 1 < s.length() && !occ.contains(s.charAt(rk + 1))) {
               occ.add(s.charAt(rk + 1));
               ++rk;
           }

           max = Math.max(max, rk - i + 1);
        }

        return max;
    }
}
