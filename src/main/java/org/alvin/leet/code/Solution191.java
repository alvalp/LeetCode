package org.alvin.leet.code;

public class Solution191 {
    public int hammingWeight(int n) {
        int ans = 0;
        while(n > 0){
            ans +=  n & 1;
            n = n >>1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution191().hammingWeight(2147483645));
    }
}
