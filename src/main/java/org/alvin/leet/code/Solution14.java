package org.alvin.leet.code;

public class Solution14 {

    public String longestCommonPrefix(String[] strs) {
        String value = strs[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            for (String s : strs) {
                if (s.length() < i+1 || s.charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"ab", "a"};
        System.out.println(new Solution14().longestCommonPrefix(strs));
    }
}
