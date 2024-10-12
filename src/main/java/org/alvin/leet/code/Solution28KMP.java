package org.alvin.leet.code;

public class Solution28KMP {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        // 构建next数组， i从1 开始， j从0开始
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            // 元素不相等， 递归回退j
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            // 如果前后缀相等，j++， 更新数组
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }

        // i 循环匹配的字符串，j来循环模式
        for (int i = 0, j = 0; i < n; i++) {
            // 匹配时如果发现不相等， j 需要回退
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            // 如果相等，继续比对下一个字符
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            // 如果比对完了，返回结果
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }


}
