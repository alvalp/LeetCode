package org.alvin.leet.code;

public class Solution289 {

    // 使用特殊字符来表示由1->0 =2  和 0->1 = -1
    public void gameOfLife(int[][] board) {

        if (board == null || board.length == 0) {
            return;
        }
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int liveCount = 0;

                // 计算细胞数量
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        int h = i + x;
                        int w = j + y;
                        if (h >= 0 && h < n && w >= 0 && w < m && board[h][w] > 0) {
                            if (i != h || w != j) {
                                liveCount++;
                            }
                        }
                    }
                }

                if (board[i][j] == 1 && liveCount < 2) {
                    board[i][j] = 2;
                } else if (board[i][j] == 1 && liveCount > 3) {
                    board[i][j] = 2;
                } else if (board[i][j] == 0 && liveCount == 3) {
                    board[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 1;
                } else if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
            }

        }
    }

    public static void main(String[] args) {
        int[][] board = {{1,1},{1,0}};
        new Solution289().gameOfLife(board);

    }
}
