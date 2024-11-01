package org.alvin.leet.code;

public class Solution66 {
    public int[] plusOne(int[] digits) {

        for(int i = digits.length -1; i >=0; i--){
            digits[i]++;
            // 如果是10， 需要取余
            digits[i] = digits[i] % 10;

            // 如果当前为0， 所以需要进位
            if(digits[i] != 0){
                return digits;
            }
        }
        digits = new int[digits.length +1];
        digits[0]= 1;
        return digits;
    }
}
