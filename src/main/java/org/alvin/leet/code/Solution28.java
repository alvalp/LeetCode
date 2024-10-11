package org.alvin.leet.code;

public class Solution28 {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            int j;
            for (j = 0; j < needle.length(); j++) {
                if (i +j > haystack.length()-1 || haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }

            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution28().strStr("aaa", "aaaa"));
    }
}
