package org.alvin.leet.code;

import java.util.HashMap;
import java.util.Map;

public class Solution76 {

    public String minWindow(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();


        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> differ = new HashMap<>();

        // 构建目标map
        for (int i = 0; i < t.length(); i++) {
            differ.put(tArray[i], differ.getOrDefault(tArray[i], 0) - 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (differ.containsKey(sArray[i]))
                differ.put(sArray[i], differ.getOrDefault(sArray[i], 0) + 1);
        }

        int distance = 0;
        for (Map.Entry<Character, Integer> entry : differ.entrySet()) {
            if (entry.getValue() < 0) {
                distance++;
            }
        }

        // 全覆盖
        if (distance == 0) {
            return s.substring(0, t.length());
        }

        String ans = "";
        for (int left = 0, right = t.length(); right < s.length(); right++) {
            if (distance > 0) {
                if (differ.containsKey(sArray[right])) {
                    differ.put(sArray[right], differ.get(sArray[right]) + 1);
                    Integer count = differ.get(sArray[right]);
                    if (count == 0) {
                        distance--;
                    }
                }
            }

            while (distance <= 0) {
                if (right - left + 1 < ans.length() || ans.equals("")) {
                    ans = s.substring(left, right + 1);
                }

                if (differ.containsKey(sArray[left])) {
                    differ.put(sArray[left], differ.get(sArray[left]) - 1);
                    Integer count = differ.get(sArray[left]);
                    if (count == -1) {
                        distance++;
                    }
                }
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(new Solution76().minWindow("abc", "cba"));
    }


}
