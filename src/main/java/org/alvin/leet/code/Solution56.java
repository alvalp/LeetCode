package org.alvin.leet.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length ==0){
            return new int[0][2];
        }

        // 按照左端点进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]- o2[0];
            }
        });

        List<int[]> ans = new ArrayList<>();
        for (int i = 0 ; i < intervals.length; i++){
            int min = intervals[i][0];
            int max = intervals[i][1];
            int lastIndex = ans.size()-1;
            // 左端点大于，合并的右端点。 说明不连续
            if(ans.isEmpty() || ans.get(lastIndex)[1] < min){
               ans.add(new int[]{min, max});
            }else{
                // 说明连续， 此时需要更新右端点
                ans.get(lastIndex)[1] = Math.max(ans.get(lastIndex)[1], max);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
