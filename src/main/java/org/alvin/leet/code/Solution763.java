package org.alvin.leet.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution763 {
    public int climbStairs(int n) {
        if(n <=3){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for (int i =3; i <=n ; i++){
            dp[i] =  dp[i-1]+ dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
//        System.out.println(new Solution763().partitionLabels("ababcbacadefegdehijhklij"));
    }
}
