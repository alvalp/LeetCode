package org.alvin.leet.code;

import java.util.ArrayList;
import java.util.List;

public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        List<List<Integer>> values = new ArrayList<>();
        for (int i = 0; i < 27; i++) {
            values.add(new ArrayList<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!Character.isDigit(board[i][j])) {
                    continue;
                }
                int index = (i / 3) * 3 + j / 3;
                values.get(index).add(board[i][j] - '0');
                // 先行i 0~9， 后列j 9-18， 然后 宫格
                values.get(9 + i).add(board[i][j] - '0');
                values.get(18 + j).add(board[i][j] - '0');
            }
        }

        for (int i = 0; i < 27; i++) {
            int[] temp = new int[10];
            for (Integer v : values.get(i)) {
                temp[v]++;
                if (temp[v] >= 2) {
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(new Solution36().isValidSudoku(board));

    }
}
