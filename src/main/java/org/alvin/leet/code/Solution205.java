package org.alvin.leet.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapping = new HashMap<>();
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        if(t.length() != s.length()){
            return false;
        }

        for (int i = 0 ; i < sCharArray.length; i++){
            Character c = sCharArray[i];
            if(!mapping.containsKey(c)){
                mapping.put(sCharArray[i], tCharArray[i]);
            }
            else if(mapping.containsKey(c) && tCharArray[i] != mapping.get(c)){
                return false;
            }
        }

       return new HashSet<>(mapping.values()).size() == mapping.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution205().isIsomorphic("paper","title"));
    }
}
