package org.alvin.leet.code;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 本质上就是围绕四周转一圈
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ans;
        }

        int total = matrix.length * matrix[0].length;

        int left = 0, top = 0, bottom = matrix.length - 1, right = matrix[0].length - 1;
        while (total > 0) {
            // 从做到右
            for (int i = left; i <= right && total > 0; i++) {
                ans.add(matrix[top][i]);
                total--;
            }
            top++;

            for (int i = top; i <= bottom && total > 0; i++) {
                ans.add(matrix[i][right]);
                total--;
            }
            right--;

            for (int i = right; i >= left && total > 0; i--) {
                ans.add(matrix[bottom][i]);
                total--;
            }
            bottom--;

            //注意 i >的边界值
            for (int i = bottom; i >= top && total > 0; i--) {
                ans.add(matrix[i][left]);
                total--;
            }
            left++;
        }
        return ans;
    }
}
