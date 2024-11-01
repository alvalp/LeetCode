package org.alvin.leet.code;

public class Solution172 {

    /**
     * 本质上就是求5的的质数的个数， 只有2 * 5 才能出现0. 而且
     * 2 质数出现的比例要严重高于5. 所以就是统计5的质数个数
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int ans = 0;
        //只有5的倍数才有可能出现
        for(int i =5; i<=n ; i= i+5){
            // 例如25 ， 会出现2个5.
            for (int x = i; x % 5 ==0; x = x/5){
                ans++;
            }
        }
        return ans;
    }

}
