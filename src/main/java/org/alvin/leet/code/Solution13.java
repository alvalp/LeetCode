package org.alvin.leet.code;

import java.util.HashMap;
import java.util.Map;

public class Solution13 {
    Map<Character, Integer> symbolValues = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            //如果前一个值小于后一个值， 就减去当前值
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution13().romanToInt("MMMXLV"));
    }
}
