package org.alvin.leet.code;

public class Solution209 {

    //滑动窗口，本质上就是以right 为基准的判断。 以每一个right为基准，计算此时的最小子串
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int value = 0;
        // 外层循环right 一直往右移动
        for (int left =0, right =0 ;right < nums.length; right++){
            value += nums[right];
            // 内部循环 left 一直往右移, 这里需要》=
            while (value >=  target){
                // 如果left = right 则只是存在1
                ans = Math.min(ans, right -left +1);
                value -= nums[left];
                left++;
            }
        }
        return ans  == Integer.MAX_VALUE ? 0 : ans;
    }


    public static void main(String[] args) {
        int [] nums = {2,3,1,2,4,3};

        System.out.println(new Solution209().minSubArrayLen(7, nums));
    }
}
