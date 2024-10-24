package org.alvin.leet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if(nums.length == 0){
            return ans;
        }
        Integer start = null, end = null;
        for (int i =0 ; i < nums.length; i++){
            if(start == null){
                start = end = nums[i];
                continue;
            }
            if(nums[i] == end+1){
                end++;
            }else{
                if(end == start){
                    ans.add(start+"");
                }else{
                    ans.add(start+"->"+end);
                }
                start = end = nums[i];
            }
        }

        if(Objects.equals(end, start)){
            ans.add(start+"");
        }else{
            ans.add(start+"->"+end);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        System.out.println(new Solution228().summaryRanges(nums));
    }
}
