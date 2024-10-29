package org.alvin.leet.code;

import java.util.HashMap;
import java.util.Map;

public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0 ;i < nums.length ; i++){
           if(map.containsKey(nums[i]) && i - map.get(nums[i])  <= k){
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int k =1 ;
        int[] nums  ={1,0,1,1};
        System.out.println(new Solution219().containsNearbyDuplicate(nums, k));
    }
}
