package org.alvin.leet.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution242 {
    public boolean isAnagram(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }
        for ( int i =0 ; i < sCharArray.length ; i++){
            map.put(sCharArray[i], map.getOrDefault(sCharArray[i], 0) +1);
            map.put(tCharArray[i], map.getOrDefault(tCharArray[i], 0) -1);
        }
        HashSet<Integer> set = new HashSet<>(map.values());
        return set.size() ==1 && set.contains(0);
    }


    public static void main(String[] args) {
        System.out.println(new Solution242().isAnagram("anagram","nagaram"));
    }
}
