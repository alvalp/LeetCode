package org.alvin.leet.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Solution496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 通过单调队列可以解决
        int length = nums1.length;
       int[] ans = new int[length];
        Arrays.fill(ans,-1);
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map  = new HashMap<>();
        for (int i =0; i < length; i++){
            map.put(nums1[i],i);
        }
        for (int i = 0; i < nums2.length ; i++){
            int v = nums2[i];
            while(!stack.isEmpty() && stack.peek() < v){
                Integer value = stack.pop();
                if(map.containsKey(value)){
                    ans[map.get(value)]= v;
                }
            }
            stack.push(v);
        }
        return ans;
    }
}
