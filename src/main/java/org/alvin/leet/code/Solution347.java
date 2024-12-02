package org.alvin.leet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int v : nums) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }

        // 从0开始， 也可能所以值都是一样的
        List<Integer>[] count = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (count[entry.getValue()] == null) {
                count[entry.getValue()] = new ArrayList<>();
            }
            count[entry.getValue()].add(entry.getKey());
        }
        List<Integer> ans = new ArrayList<>();
        int total = 0;
        for (int i = count.length - 1; i >= 0 && total < k; i--) {
            if (count[i] == null) {
                continue;
            }
            ans.addAll(count[i]);
            total = ans.size();
        }

        return ans.stream().mapToInt(i ->i).toArray();
    }

    public static void main(String[] args) {
        int[]nums = {1,1,1,2,2,3};
        System.out.println(new Solution347().topKFrequent(nums, 2));
    }
}
