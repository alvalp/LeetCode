package org.alvin.leet.code;

import java.util.Arrays;

public class Solution103 {
    private void dfs(char[][] board, int w, int h, int width, int height) {
        // 碰到边界了
        if (w < 0 || h < 0 || h >= height || w >= width || board[h][w] != 'O') {
            return;
        }

        //向四周遍历
        board[h][w] = 'Y';
        dfs(board, w - 1, h, width, height);
        dfs(board, w + 1, h, width, height);
        dfs(board, w, h - 1, width, height);
        dfs(board, w, h + 1, width, height);
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int width = board[0].length;
        int height = board.length;

        for (int h = 0; h < height; h++) {
            dfs(board, 0, h, width, height);
            dfs(board, width - 1, h, width, height);
        }
        for (int w = 0; w < width; w++) {
            dfs(board, w, 0, width, height);
            dfs(board, w, height - 1, width, height);

        }

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                board[h][w] = board[h][w] == 'Y' ? 'O' : 'X';
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'O', 'O'}, {'O', 'O'}};
        new Solution103().solve(board);
        int width = board[0].length;
        int height = board.length;
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                System.out.print(board[h][w]);
            }
            System.out.println();
        }
    }
}
