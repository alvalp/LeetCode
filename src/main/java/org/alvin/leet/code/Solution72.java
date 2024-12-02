package org.alvin.leet.code;

public class Solution72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // 很巧妙
        if (m == 0 || n == 0) {
            return m + n;
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            //删除全部字符
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            //添加全部字符
            dp[0][i] = i;
        }

        char[] array1 = word1.toCharArray();
        char[] array2 = word2.toCharArray();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //可以删除array[i], 变成dp[i-1][j]
                int left = dp[i - 1][j] + 1;
                // 可以删除一个array2[j], 变成dp[i][j-1]
                int down = dp[i][j - 1] + 1;
                // 也可以从dp[i-1][j-1] 变化得到，但是要看最后的字符是否相等
                int leftDown = dp[i - 1][j - 1];
                //如果不相等，需要添加异步转化
                if (array1[i - 1] != array2[j - 1]) {
                    leftDown += 1;
                }

                dp[i][j] = Math.min(left, Math.min(down, leftDown));
            }

        }
        return dp[m][n];
    }
}
