package org.alvin.leet.code;

public class Solution9 {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        int value = x ;
        int ans = 0;
        while(value >0){
            ans = ans * 10 + value % 10;
            value = value/ 10;
        }
        return ans == x;
    }

    public static void main(String[] args) {
        System.out.println(new Solution9().isPalindrome(10));
    }
}
