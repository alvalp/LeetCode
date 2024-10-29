package org.alvin.leet.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 已经排序好了, 边界情况不好处理
        List<int[]> merge = new ArrayList<>();
        boolean hasMerge= false;
        for (int[] interval : intervals) {
            if (!hasMerge && interval[0] > newInterval[0]) {
                merge.add(newInterval);
            }
            merge.add(interval);
        }
        if(merge.size() == intervals.length){
            merge.add(newInterval);
        }
        List<int[]> ans = new ArrayList<>();
        for (int[] value : merge) {
            int min = value[0];
            int max = value[1];
            int index = ans.size() - 1;

            if (ans.isEmpty() || ans.get(index)[1] < min) {
                ans.add(new int[]{min, max});
            } else {
                ans.get(index)[1] = Math.max(ans.get(index)[1], max);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }


    public static void main(String[] args) {
        int[][] intervals ={{1,3},{6,9}};
        int[] newInterval ={2,5};
        int[][] insert = new Solution57().insert(intervals, newInterval);
       for (int i =0; i < insert.length; i++){
           System.out.println(insert[i][0]+","+insert[i][1]);
       }
    }
}
