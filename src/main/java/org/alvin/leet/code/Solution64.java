package org.alvin.leet.code;

public class Solution64 {
    public int minPathSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int[][] dp = new int[height][width];
        int total = 0;
        for (int i = 0; i < width; i++) {
            total += grid[0][i];
            dp[0][i] = total;
        }
        total = 0;
        for (int i = 0; i < height; i++) {
            total += grid[i][0];
            dp[i][0] = total;
        }

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[height - 1][width - 1];
    }
}
