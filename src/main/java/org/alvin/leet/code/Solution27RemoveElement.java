package org.alvin.leet.code;

import java.util.Arrays;

public class Solution27RemoveElement {

    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[left++] = nums[i];
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] num = {0, 1, 2, 2, 3, 0, 4, 2};

        int ans = new Solution27RemoveElement().removeElement(num, 2);
        System.out.println(ans);
        System.out.println(Arrays.toString(num));
    }
}
