package org.alvin.leet.code;

public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        char[] array1 = text1.toCharArray();
        char[] array2 = text2.toCharArray();
        int n = text2.length();
        // 定义最长公共子序列的长度
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                // 因为都是从1 开始的，需要-1
                if(array1[i-1] == array2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] =Math.max(dp[i][j-1], dp[i-1][j]) ;
                }
            }
        }
        return dp[m][n];
    }
}
