package org.alvin.leet.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution5 {

    public int findMinArrowShots(int[][] points) {

        List<int[]> ans = new ArrayList<>();
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] source, int[] targe) {
                if(source[0] == targe[0]){
                    return 0;
                }

                return source[0] > targe[0] ? 1: -1;
            }
        });

        for (int i = 0; i < points.length; i++){
            int min = points[i][0];
            int max = points[i][1];
            int index = ans.size()-1;
            if(ans.isEmpty() || ans.get(index)[1] < min){
                ans.add(new int[]{min, max});
            }else{
                ans.get(index)[1] = Math.min(max, ans.get(index)[1]);
            }
        }
//        return ans.toArray(new int[ans.size()][]);
        return ans.size();
    }

}
