package org.alvin.leet.code;

public class Solution48 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //  上下翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }

        // 对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }
}
