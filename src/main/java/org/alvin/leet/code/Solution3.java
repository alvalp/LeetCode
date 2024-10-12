package org.alvin.leet.code;

import java.util.HashMap;
import java.util.HashSet;

import java.util.Set;

public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        int ans = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>(64);
        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // left 一个一个删除，直到和但前值不重复
            while (set.contains(c)) {
                set.remove(s.charAt(left++));
            }

            ans = Math.max(ans, right - left + 1);
            set.add(c);
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("tmmzuxt"));
    }
}

