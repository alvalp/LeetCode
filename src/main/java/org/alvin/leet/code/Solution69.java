package org.alvin.leet.code;

public class Solution69 {

    /**
     * 用二分查找最后一个比x小的值
     */
    public int mySqrt(int x) {
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 注意这个地方会越界
            if ((long)mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
