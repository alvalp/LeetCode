package org.alvin.leet.code;

public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int i = 0, j = 0;
        while(i < s.length() && j < t.length()){
            if(sArray[i]==tArray[j]){
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution392().isSubsequence("b", "c"));
    }
}
