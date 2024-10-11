package org.alvin.leet.code;

public class Solution121 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;

        for (int price : prices) {
            if (min > price) {
                min = price;
            }
            if (price - min > ans) {
                ans = price - min;
            }
        }

        return ans;
    }
}
