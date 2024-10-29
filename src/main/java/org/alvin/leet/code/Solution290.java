package org.alvin.leet.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        char[] patternCharArray = pattern.toCharArray();
        if(split.length != patternCharArray.length){
            return false;
        }
        Map<String, Character> mapping = new HashMap<>();
        for (int i =0; i < split.length; i++){
            String value = split[i];
            if(!mapping.containsKey(value)){
                mapping.put(value, patternCharArray[i]);
            } else if(patternCharArray[i] != mapping.get(value)){
                return false;
            }
        }

        return new HashSet<>(mapping.values()).size() ==  mapping.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution290().wordPattern("abba","dog cat cat dog"));
    }
}
