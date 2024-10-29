package org.alvin.leet.code;

import java.util.HashMap;
import java.util.Map;

public class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] noteArray = ransomNote.toCharArray();
        char[] magazineCharArray = magazine.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : magazineCharArray){
            map.put(c, map.getOrDefault(c, 0) +1);
        }
        for (Character c: noteArray){
            Integer i = map.get(c);
            if(i == null || i ==0){
                return  false;
            }
            map.put(c, i -1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println( new Solution383().canConstruct("aa","aab"));
    }
}
