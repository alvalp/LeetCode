package org.alvin.leet.code;

import java.util.ArrayList;
import java.util.List;

public class Solution442 {

    public List<Integer> findDuplicates(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            // 数字从1开始, 数据加上n 之后，需要取%n
            int index = (nums[i] - 1) % length;
            // 如果数字出现1次， 我就在对应的位置上加一个n
            nums[index] += length;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            // 重复的数被加上了2n ， 其他的数据只会在n ~ 2n之间
            if (nums[i] > 2* length) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums ={4,3,2,7,8,2,3,1};
        System.out.println(new Solution442().findDuplicates(nums));
    }

}
