package org.alvin.leet.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        // 排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return 0;
                }
                return o1[0] > o2[0] ? 1 : 0;
            }
        });

        // 求交集
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            int min = points[i][0];
            int max = points[i][1];
            int index = ans.size() - 1;
            // 没有交集
            if (ans.isEmpty() || ans.get(index)[1] < min) {
                ans.add(new int[]{min, max});
            } else {
                ans.get(index)[1] = Math.min(ans.get(index)[1], max);
            }
        }
        return ans.size();
    }

    public static void main(String[] args) {
        int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        System.out.println(new Solution452().findMinArrowShots(points));
    }
}
