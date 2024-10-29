package org.alvin.leet.code;

import java.util.HashSet;
import java.util.Set;

public class Solution202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while(n != 1){
            if(set.contains(n)){
                return false;
            }
            set.add(n);

            int value = 0;
            while(n != 0){
                int c = n % 10;
                value += c * c;
                n = n / 10;
            }
            n = value;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution202().isHappy(2));
    }
}
