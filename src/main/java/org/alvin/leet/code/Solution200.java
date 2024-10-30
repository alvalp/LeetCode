package org.alvin.leet.code;

public class Solution200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int height = grid.length;
        int width = grid[0].length;
        int count = 0;
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (grid[h][w] == '1') {
                    count++;
                    // 从这个点开始深度优先搜索， 将可达的点设置为0
                    dfs(grid, w, h, width, height);
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int w, int h, int width, int height) {
        // 已经遍历到边界了， 可以结束循环
        if (w < 0 || h < 0 || w >= width || h >= height || grid[h][w] == '0') {
            return;
        }

        grid[h][w] = '0';
        // 向四周遍历
        dfs(grid, w - 1, h, width, height);
        dfs(grid, w + 1, h, width, height);
        dfs(grid, w, h - 1, width, height);
        dfs(grid, w, h + 1, width, height);
    }
}
