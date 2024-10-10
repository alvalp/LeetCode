package org.alvin.leet.code;

import java.util.Arrays;

public class Solution88MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m - 1, j = n - 1, k = m + n - 1; i >= 0 || j >= 0; k--) {
            if (i < 0) {
                nums1[k] = nums2[j--];
                continue;
            }
            if (j < 0) {
                nums1[k] = nums1[i--];
                continue;
            }

            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i--];
            } else {
                nums1[k] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        new Solution88MergeSortedArray().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
