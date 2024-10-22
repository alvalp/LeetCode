package org.alvin.leet.code;

public class Solution70 {

    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }

        int[] values = new int[n + 1];
        values[0] = 0;
        values[1] = 1;
        values[2] = 2;

        for (int i = 3; i <= n; i++) {
            values[i] = values[i - 1] + values[i - 2];
        }
        return values[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution70().climbStairs(4));
    }


}
